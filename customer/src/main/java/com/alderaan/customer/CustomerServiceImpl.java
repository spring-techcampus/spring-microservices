package com.alderaan.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
record CustomerServiceImpl(
        CustomerRepository customerRepository,
        CustomerMapperService customerMapperService
) implements CustomerService {

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        return customerList.stream()
                .map(customerMapperService::mapToDto)
                .toList();
    }

    @Override
    public CustomerDto findCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElse(null);
        return customerMapperService.mapToDto(customer);
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = customerMapperService.mapToEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapperService.mapToDto(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomerById(UUID id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElse(null);

        Customer customerToUpdate = customerMapperService.updateEntity(customer, customerDto);
        Customer updatedCustomer = customerRepository.save(customerToUpdate);
        return customerMapperService.mapToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(UUID id) {
        customerRepository.deleteById(id);
    }
}
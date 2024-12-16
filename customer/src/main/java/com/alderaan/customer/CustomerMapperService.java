package com.alderaan.customer;

import org.springframework.stereotype.Service;

@Service
record CustomerMapperService() {

    public CustomerDto mapToDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName());
    }

    public Customer mapToEntity(CustomerDto customerDto) {
        return new Customer(
                customerDto.id(),
                customerDto.name());
    }

    public Customer updateEntity(Customer customer, CustomerDto customerDto) {
        customer.setName(customerDto.name());
        return customer;
    }
}
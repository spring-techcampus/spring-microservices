package com.alderaan.customer;

import java.util.List;
import java.util.UUID;

interface CustomerService {

    List<CustomerDto> findAllCustomers();
    CustomerDto findCustomerById(UUID id);
    CustomerDto saveCustomer(CustomerDto customerDto);
    CustomerDto updateCustomerById(UUID id, CustomerDto customerDto);
    void deleteCustomerById(UUID id);
}

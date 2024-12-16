package com.alderaan.customer;

import com.alderaan.customer.common.constant.HttpConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(HttpConstant.Request.Path.CUSTOMER)
record CustomerController(CustomerService customerService) {

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customerDtoList = customerService.findAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id) {
        CustomerDto customerDto = customerService.findCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomerDto = customerService.saveCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomerDto = customerService.updateCustomerById(id, customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomerById(@PathVariable UUID id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
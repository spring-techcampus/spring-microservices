package com.alderaan.customer;

import com.alderaan.customer.common.constant.HttpConstant;
import com.alderaan.customer.common.exception.dto.ErrorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Customer - REST API Endpoints",
        description = "Customer - REST API Endpoints to get, create, update and delete customer details"
)
@RestController
@RequestMapping(HttpConstant.Request.Path.CUSTOMER)
record CustomerController(CustomerService customerService) {

    @Operation(
            summary = "Get All Customers - REST API",
            description = "REST API to Get All Customers"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - OK"
    )
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customerDtoList = customerService.findAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customerDtoList);
    }

    @Operation(
            summary = "Get Customer By ID - REST API",
            description = "REST API to Get the Customer details based on its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status - OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status - Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )}
    )
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID id) {
        CustomerDto customerDto = customerService.findCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(
            summary = "Create Customer - REST API",
            description = "REST API to Create Customer with the given details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status - Created"
    )
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomerDto = customerService.saveCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerDto);
    }

    @Operation(
            summary = "Update Customer By ID - REST API",
            description = "REST API to Update Customer details based on its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status - OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status - Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status - Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )}
    )
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomerDto = customerService.updateCustomerById(id, customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomerDto);
    }

    @Operation(
            summary = "Delete Customer By ID - REST API",
            description = "REST API to Delete the Customer based on its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status - OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomerById(@PathVariable UUID id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
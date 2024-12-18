package com.alderaan.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

record CustomerDto(
        @Schema(
                name = "Customer ID",
                description = "Customer ID of the customer",
                example = "123e4567-e89b-12d3-a456-426614174101"
        )
        UUID id,

        @Schema(
                name = "Customer Name",
                description = "Customer Name of the customer",
                example = "Customer Seven"
        )
        @NotEmpty(message = "Customer Name can not be null or empty")
        String name
) {
}
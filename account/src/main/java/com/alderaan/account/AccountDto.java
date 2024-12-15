package com.alderaan.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

@Schema(
        name = "AccountDto",
        description = "Data Transfer Object for Account details"
)
record AccountDto(
        @Schema(
                name = "Account ID",
                description = "Account ID of the account",
                example = "123e4567-e89b-12d3-a456-426614174001"
        )
        UUID id,

        @Schema(
                name = "Account Name",
                description = "Account Name of the account",
                example = "Account Seven"
        )
        @NotEmpty(message = "Account Name can not be a null or empty")
        String name
) {
}

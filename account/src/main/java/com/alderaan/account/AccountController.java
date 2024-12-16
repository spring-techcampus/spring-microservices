package com.alderaan.account;

import com.alderaan.account.common.constant.HttpConstant;
import com.alderaan.account.common.exception.dto.ErrorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Account - REST API Endpoints",
        description = "Account - REST API Endpoints to get, create, update and delete account details"
)
@RestController
@RequestMapping(HttpConstant.Request.Path.ACCOUNT)
record AccountController(AccountService accountService) {

    @Operation(
            summary = "Get All Accounts - REST API",
            description = "REST API to Get All Accounts"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - OK"
    )
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDtoList = accountService.findAllAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
    }

    @Operation(
            summary = "Get Account By ID - REST API",
            description = "REST API to Get the Account details based on its ID"
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
    public ResponseEntity<AccountDto> getAccountById(@PathVariable UUID id) {
        AccountDto accountDto = accountService.findAccountById(id);
        return ResponseEntity.status(HttpStatus.OK).body(accountDto);
    }

    @Operation(
            summary = "Create Account - REST API",
            description = "REST API to Create Account with the given details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status - Created"
    )
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto) {
        AccountDto createdAccountDto = accountService.saveAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccountDto);
    }

    @Operation(
            summary = "Update Account By ID - REST API",
            description = "REST API to Update Account details based on its ID"
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
    public ResponseEntity<AccountDto> updateAccountById(@PathVariable UUID id, @Valid @RequestBody AccountDto accountDto) {
        AccountDto updatedAccountDto = accountService.updateAccountById(id, accountDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAccountDto);
    }

    @Operation(
            summary = "Delete Account By ID - REST API",
            description = "REST API to Delete the Account based on its ID"
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
    public ResponseEntity<AccountDto> deleteAccountById(@PathVariable UUID id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
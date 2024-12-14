package com.alderaan.account;

import com.alderaan.account.common.constant.HttpConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(HttpConstant.Request.Path.ACCOUNT)
record AccountController(AccountService accountService) {

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDtoList = accountService.findAllAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accountDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable UUID id) {
        AccountDto accountDto = accountService.findAccountById(id);
        return ResponseEntity.status(HttpStatus.OK).body(accountDto);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccountDto = accountService.saveAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccountDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable UUID id, @RequestBody AccountDto accountDto) {
        AccountDto updatedAccountDto = accountService.updateAccount(id, accountDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAccountDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable UUID id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
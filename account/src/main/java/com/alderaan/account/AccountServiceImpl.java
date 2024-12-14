package com.alderaan.account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
record AccountServiceImpl(
        AccountMapperService accountMapperService,
        AccountRepository accountRepository
) implements AccountService {

    @Override
    public List<AccountDto> findAllAccounts() {
        List<Account> accountList = accountRepository.findAll();

        return accountList.stream()
                .map(accountMapperService::mapToDto)
                .toList();
    }

    @Override
    public AccountDto findAccountById(UUID id) {
        Account account = accountRepository.findById(id).orElse(null);
        return accountMapperService.mapToDto(account);
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        Account account = accountMapperService.mapToEntity(accountDto);
        Account savedAccount = accountRepository.save(account);
        return accountMapperService.mapToDto(savedAccount);
    }

    @Override
    public AccountDto updateAccount(UUID id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            return null;
        }

        Account accountToUpdate = accountMapperService.updateEntity(account, accountDto);
        Account updatedAccount = accountRepository.save(accountToUpdate);
        return accountMapperService.mapToDto(updatedAccount);
    }

    @Override
    public void deleteAccountById(UUID id) {
        accountRepository.deleteById(id);
    }
}
package com.alderaan.account;

import org.springframework.stereotype.Service;

@Service
record AccountMapperService() {

    public AccountDto mapToDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName());
    }

    public Account mapToEntity(AccountDto accountDto) {
        return new Account(
                accountDto.id(),
                accountDto.name());
    }

    public Account updateEntity(Account account, AccountDto accountDto) {
        account.setName(accountDto.name());
        return account;
    }
}
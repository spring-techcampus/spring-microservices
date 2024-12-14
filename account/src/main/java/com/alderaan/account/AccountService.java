package com.alderaan.account;

import java.util.List;
import java.util.UUID;

interface AccountService {

    List<AccountDto> findAllAccounts();
    AccountDto findAccountById(UUID id);
    AccountDto saveAccount(AccountDto accountDto);
    AccountDto updateAccount(UUID id, AccountDto accountDto);
    void deleteAccountById(UUID id);
}

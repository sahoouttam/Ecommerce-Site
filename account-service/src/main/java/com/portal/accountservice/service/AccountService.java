package com.portal.accountservice.service;

import com.portal.accountservice.dto.AccountDto;
import com.portal.accountservice.payload.AccountRequest;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllAccounts();

    void createAccount(AccountRequest accountRequest);

    AccountDto getAccountById(Long id);

    void deleteAccountById(Long id);
}

package com.portal.accountservice.service;

import com.portal.accountservice.client.RestClient;
import com.portal.accountservice.dto.AccountDto;
import com.portal.accountservice.exception.AccountNotFoundException;
import com.portal.accountservice.mapper.AccountMapper;
import com.portal.accountservice.payload.AccountRequest;
import com.portal.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final RestClient restClient;

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountMapper::convertAccount)
                .peek(accountDto -> accountDto
                        .setItemDto(restClient.
                                getItemById(accountDto.
                                        getItemDto().getId())
                                .getBody()))
                .collect(Collectors.toList());
    }

    @Override
    public void createAccount(AccountRequest accountRequest) {
        accountRepository.save(AccountMapper.convertAccountRequest(accountRequest));
    }

    @Override
    public AccountDto getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(AccountMapper::convertAccount)
                .map(accountDto -> {
                    accountDto.setItemDto(restClient
                            .getItemById(accountDto.getItemDto().getId())
                            .getBody());
                    return accountDto;})
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + id));

    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }
}

package com.portal.accountservice.controller;

import com.portal.accountservice.dto.AccountDto;
import com.portal.accountservice.payload.AccountRequest;
import com.portal.accountservice.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("/account")
    public ResponseEntity<HttpStatus> createAccount(@RequestBody AccountRequest accountRequest) {
        accountService.createAccount(accountRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/account")
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable Long id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

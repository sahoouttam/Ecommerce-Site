package com.portal.accountservice.mapper;

import com.portal.accountservice.dto.AccountDto;
import com.portal.accountservice.dto.ItemDto;
import com.portal.accountservice.entity.Account;
import com.portal.accountservice.payload.AccountRequest;

public class AccountMapper {

    private AccountMapper() {}

    public static AccountDto convertAccount(Account account) {
        return AccountDto.builder()
                .isPayed(account.getIsPayed())
                .paymentStatus(account.getPaymentStatus())
                .itemDto(ItemDto.builder()
                        .id(account.getItemId())
                        .build())
                .build();
    }

    public static Account convertAccountRequest(AccountRequest accountRequest) {
        return Account.builder()
                .itemId(accountRequest.getItemId())
                .isPayed(accountRequest.getIsPayed())
                .paymentStatus(accountRequest.getPaymentStatus())
                .build();
    }
}

package com.portal.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.portal.accountservice.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Boolean isPayed;

    private PaymentStatus paymentStatus;

    @JsonProperty("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ItemDto itemDto;

}

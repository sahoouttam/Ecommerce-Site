package com.portal.accountservice.payload;

import com.portal.accountservice.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    private Long itemId;

    private Boolean isPayed;

    private PaymentStatus paymentStatus;
}

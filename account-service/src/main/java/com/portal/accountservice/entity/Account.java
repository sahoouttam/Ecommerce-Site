package com.portal.accountservice.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Builder
@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "is_payed")
    private Boolean isPayed;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
}

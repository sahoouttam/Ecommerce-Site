package com.portal.orderservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

}

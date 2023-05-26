package com.portal.inventoryservice.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Builder
@Table(name = "inventories")
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "quantity")
    private Integer quantity;
}

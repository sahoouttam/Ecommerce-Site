package com.portal.orderservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Setter
@Getter
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<Item> items;
}

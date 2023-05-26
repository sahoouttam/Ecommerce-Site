package com.portal.accountservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;

    private String itemCode;

    private Integer quantity;

    private Double price;
}

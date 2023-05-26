package com.portal.orderservice.dto;

import lombok.Data;

@Data
public class InventoryResponse {

    private String itemCode;

    private Boolean inStock;
}

package com.portal.inventoryservice.mapper;

import com.portal.inventoryservice.entity.Inventory;
import com.portal.inventoryservice.payload.InventoryRequest;
import com.portal.inventoryservice.payload.InventoryResponse;

public class InventoryMapper {

    private InventoryMapper() {}
    public static Inventory convertInventoryRequest(InventoryRequest inventoryRequest) {
        return Inventory.builder()
                .productCode(inventoryRequest.getProductCode())
                .quantity(inventoryRequest.getQuantity())
                .build();
    }

    public static InventoryResponse convertInventory(Inventory inventory) {
        return InventoryResponse.builder()
                .productCode(inventory.getProductCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}

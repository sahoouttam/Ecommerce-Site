package com.portal.inventoryservice.service;

import com.portal.inventoryservice.payload.InventoryRequest;
import com.portal.inventoryservice.payload.InventoryResponse;

import java.util.List;

public interface InventoryService {

    void createInventory(InventoryRequest inventoryRequest);

    List<InventoryResponse> getAllInventories();

    InventoryResponse getInventoryById(Long id);
}

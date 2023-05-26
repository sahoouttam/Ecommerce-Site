package com.portal.inventoryservice.service;

import com.portal.inventoryservice.entity.Inventory;
import com.portal.inventoryservice.exception.InventoryNotFoundException;
import com.portal.inventoryservice.mapper.InventoryMapper;
import com.portal.inventoryservice.payload.InventoryRequest;
import com.portal.inventoryservice.payload.InventoryResponse;
import com.portal.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public void createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = InventoryMapper.convertInventoryRequest(inventoryRequest);
        inventoryRepository.save(inventory);
    }

    @Override
    public List<InventoryResponse> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(InventoryMapper::convertInventory)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryResponse getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .map(InventoryMapper::convertInventory)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory not found with id " + id));
    }
}

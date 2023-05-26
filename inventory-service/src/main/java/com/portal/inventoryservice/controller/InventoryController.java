package com.portal.inventoryservice.controller;

import com.portal.inventoryservice.payload.InventoryRequest;
import com.portal.inventoryservice.payload.InventoryResponse;
import com.portal.inventoryservice.service.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryServiceImpl inventoryService;

    @PostMapping("/inventories")
    public ResponseEntity<HttpStatus> createInventory(@RequestBody InventoryRequest inventoryRequest) {
        inventoryService.createInventory(inventoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<InventoryResponse>> getAllInventories() {
        return new ResponseEntity<>(inventoryService.getAllInventories(), HttpStatus.OK);
    }


    @GetMapping("/inventories/{id}")
    public ResponseEntity<InventoryResponse> getInventoryById(@PathVariable Long id) {
        return new ResponseEntity<>(inventoryService.getInventoryById(id), HttpStatus.OK);
    }
}

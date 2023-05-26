package com.portal.accountservice.client;

import com.portal.accountservice.dto.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@FeignClient(value = "ORDER-SERVICE", url = "http://localhost:8081")
public interface RestClient {
    public ResponseEntity<ItemDto> getItemById(Long id);
}

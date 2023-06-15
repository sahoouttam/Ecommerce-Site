package com.portal.orderservice.service;

import com.portal.orderservice.config.RabbitMQProducer;
import com.portal.orderservice.dto.InventoryResponse;
import com.portal.orderservice.dto.ItemDto;
import com.portal.orderservice.payload.OrderResponse;
import com.portal.orderservice.entity.Order;
import com.portal.orderservice.exception.OutOfStockException;
import com.portal.orderservice.exception.ResourceNotFoundException;
import com.portal.orderservice.mapper.OrderMapper;
import com.portal.orderservice.payload.OrderRequest;
import com.portal.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;

    private final RabbitMQProducer rabbitMQProducer;

    public void createOrder(OrderRequest orderRequest) {
        Order order = OrderMapper.convertOrderRequest(orderRequest);
        List<String> itemCodes = orderRequest.getItems()
                .stream()
                .map(ItemDto::getItemCode)
                .collect(Collectors.toList());

        InventoryResponse[] inventoryResponses = webClient.get()
                .uri("http://inventory-service/api/v1/inventories",
                        uriBuilder -> uriBuilder.queryParam("itemCode", itemCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();


        assert inventoryResponses != null;
        boolean allItemInStock = Arrays.stream(inventoryResponses)
                .allMatch(InventoryResponse::getInStock);

        if (allItemInStock) orderRepository.save(order);
        else throw new OutOfStockException("Out of stock");

        new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::convertOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        OrderResponse orderResponse = orderRepository.findById(id)
                .map(OrderMapper::convertOrder)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        rabbitMQProducer.send(orderResponse);
        return orderResponse;
    }

    public void updateOrder(OrderRequest orderRequest, Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        orderRepository.save(OrderMapper.updateOrder(order, orderRequest));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

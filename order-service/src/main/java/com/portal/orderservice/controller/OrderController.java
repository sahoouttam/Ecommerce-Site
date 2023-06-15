package com.portal.orderservice.controller;

import com.portal.orderservice.payload.OrderResponse;
import com.portal.orderservice.payload.OrderRequest;
import com.portal.orderservice.repository.OrderRepository;
import com.portal.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;
    private final OrderRepository orderRepository;

    @CircuitBreaker(name = "createOrderFallBack", fallbackMethod = "createOrderFallBack")
    @PostMapping("/orders")
    public ResponseEntity<HttpStatus> createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponse> getOrderByOrderNumber(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> updateOrder(@RequestBody OrderRequest orderRequest, @PathVariable Long id) {
        orderService.updateOrder(orderRequest, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> createOrderFallBack() {
        return new ResponseEntity<>("Order Failed", HttpStatus.EXPECTATION_FAILED);
    }
 }

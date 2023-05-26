package com.portal.orderservice.mapper;

import com.portal.orderservice.dto.OrderDto;
import com.portal.orderservice.entity.Item;
import com.portal.orderservice.entity.Order;
import com.portal.orderservice.payload.OrderRequest;

import java.util.stream.Collectors;

public class OrderMapper {

    public static Order convertOrderRequest(OrderRequest orderRequest) {
        return Order.builder()
                .orderNumber(orderRequest.getOrderNumber())
                .items(orderRequest.getItems()
                        .stream()
                        .map(itemDto -> Item.builder()
                                .id(itemDto.getId())
                                .itemCode(itemDto.getItemCode())
                                .quantity(itemDto.getQuantity())
                                .price(itemDto.getPrice())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static OrderDto convertOrder(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .orderName(order.getOrderNumber())
                .build();
    }

    public static Order updateOrder(Order order, OrderRequest orderRequest) {
        order.setOrderNumber(order.getOrderNumber());
        order.setItems(orderRequest.getItems()
                .stream()
                .map(itemDto -> Item.builder()
                        .id(itemDto.getId())
                        .itemCode(itemDto.getItemCode())
                        .quantity(itemDto.getQuantity())
                        .price(itemDto.getPrice())
                        .build())
                .collect(Collectors.toList()));
        return order;
    }
}

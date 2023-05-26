package com.portal.orderservice.mapper;

import com.portal.orderservice.dto.ItemDto;
import com.portal.orderservice.entity.Item;

public class ItemMapper {

    public static Item convertItemRequest(ItemDto itemRequest) {
        return Item.builder()
                .itemCode(itemRequest.getItemCode())
                .quantity(itemRequest.getQuantity())
                .price(itemRequest.getPrice())
                .build();
    }
}

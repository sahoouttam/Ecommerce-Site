package com.portal.orderservice.payload;

import com.portal.orderservice.dto.ItemDto;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String orderNumber;

    private List<ItemDto> items;
}

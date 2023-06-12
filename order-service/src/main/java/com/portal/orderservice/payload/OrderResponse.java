package com.portal.orderservice.payload;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;

    private String orderName;
}

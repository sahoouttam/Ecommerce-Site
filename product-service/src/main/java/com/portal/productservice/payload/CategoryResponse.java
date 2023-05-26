package com.portal.productservice.payload;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private long id;

    private String name;
}

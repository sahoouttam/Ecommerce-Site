package com.portal.wishlistservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDto {

    private Long productId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate;

    @JsonProperty("product")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProductDto productDto;
}

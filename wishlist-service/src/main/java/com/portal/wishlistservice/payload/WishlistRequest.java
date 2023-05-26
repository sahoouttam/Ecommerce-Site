package com.portal.wishlistservice.payload;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistRequest {

    private Long productId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate;
}

package com.springboot.advanced_jpa.data.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    private Long number;
    private String name;
    private Integer price;
    private Integer stock;
}

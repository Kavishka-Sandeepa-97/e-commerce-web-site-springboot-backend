package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String productName;
    private Double price;
    private Double qty;
    private Long categoryId;
}

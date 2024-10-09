package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String produvtName;
    private Double price;
    private Integer qty;
    private Long categoryId;
}

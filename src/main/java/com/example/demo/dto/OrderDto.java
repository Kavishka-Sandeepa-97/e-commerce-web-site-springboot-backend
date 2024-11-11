package com.example.demo.dto;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private List<ProductQuantity> products;

    @Data
    public static class ProductQuantity {
        private Long productId;
        private Double quantity;
    }

}

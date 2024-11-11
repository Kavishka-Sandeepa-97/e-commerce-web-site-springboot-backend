package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> getAllOrders();
    List<Orders> getOrdersByProductId(Long productId);
    Orders getOrderByOrderId(Long id);
    Orders createOrder(OrderDto order);

}

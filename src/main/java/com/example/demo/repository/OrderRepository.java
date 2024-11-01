package com.example.demo.repository;

import com.example.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> getAllOrders();
    List<Orders> getOrdersByProductId(Long productId);
    Orders getOrderByOrderId(Long id);
    Orders createOrder(Orders order);
}

package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Orders> getAllOrders() {
       return orderRepository.findAll();
    }

    @Override
    public List<Orders> getOrdersByProductId(Long productId) {
        return null;
    }

    @Override
    public Orders getOrderByOrderId(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Orders createOrder(OrderDto orderDto){
        Orders order = new Orders();
        order.setDateTime(LocalDateTime.now());

        Double total=0.00;
        Set<Product> products = new HashSet<>();
        for(OrderDto.ProductQuantity productQuantity:orderDto.getProducts()){


            Product product = productRepository.findById(productQuantity.getProductId()).orElse(null);

           if (product==null){
               throw new IllegalArgumentException("Product with ID " + productQuantity.getProductId() + " does not exist.");
            }else {

                Double quantity=productQuantity.getQuantity()<=0 ? null : productQuantity.getQuantity();

               if (quantity==null){
                   throw new IllegalArgumentException("Quantity of product with ID " + productQuantity.getProductId() + " is 0");
               }

                total += product.getPrice()*quantity;
               Double newQty=product.getQty()-quantity;

               if (newQty < 0) {
                   throw new IllegalArgumentException("Quantity insufficient for product ID " + productQuantity.getProductId());
               } else {
                   product.setQty(newQty);
                   productRepository.save(product);
               }

                products.add(product);

           }
        }
            order.setTotal(total);
            order.setProducts(products);
            return orderRepository.save(order);


    }
}

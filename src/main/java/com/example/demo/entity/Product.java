package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    private Double price;
    private Double qty;

    @ManyToOne
    @JoinColumn(nullable = false,name="category_idx")
    private  Category category;


    @ManyToMany(mappedBy = "products")
    private Set<Orders> orders=new HashSet<>();

}

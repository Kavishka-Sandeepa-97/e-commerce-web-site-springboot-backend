package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "categoryId",fetch = FetchType.LAZY)
    private List<Product> products;

    
}

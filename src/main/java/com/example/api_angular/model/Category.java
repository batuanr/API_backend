package com.example.api_angular.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;


}

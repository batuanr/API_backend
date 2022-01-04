package com.example.api_angular.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;
    @ManyToOne
//    @JsonManagedReference
    private Category category;




}

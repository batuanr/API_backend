package com.example.api_angular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "boolean default false")
    private Boolean checkk;
    private Date oderDate;
    @ManyToOne
    private User user;
    @OneToMany(targetEntity = CartDetail.class, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CartDetail> cartDetails;

}

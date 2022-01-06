package com.example.api_angular.repository;

import com.example.api_angular.model.Cart;
import com.example.api_angular.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {
}

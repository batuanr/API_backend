package com.example.api_angular.repository;

import com.example.api_angular.model.Cart;
import com.example.api_angular.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findAllByUserAndCheckkIsFalse(User user);
}

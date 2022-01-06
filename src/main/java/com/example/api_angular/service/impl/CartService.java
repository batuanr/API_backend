package com.example.api_angular.service.impl;

import com.example.api_angular.model.Cart;
import com.example.api_angular.model.User;
import com.example.api_angular.repository.ICartRepository;
import com.example.api_angular.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository cartRepository;

    @Override
    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart findAllByUserAndCheckkIsFalse(User user) {
        Cart cart = new Cart();
        Optional<Cart> cart1 = cartRepository.findAllByUserAndCheckkIsFalse(user);
        if (!cart1.isPresent()){
            cart.setCheckk(false);
            cart.setUser(user);
            return cart;
        }
        return cart1.get();
    }
}

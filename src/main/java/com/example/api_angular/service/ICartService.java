package com.example.api_angular.service;

import com.example.api_angular.model.Cart;
import com.example.api_angular.model.User;

import java.util.Optional;

public interface ICartService extends IGeneralService<Cart>{
    Cart findAllByUserAndCheckkIsFalse(User user);
}

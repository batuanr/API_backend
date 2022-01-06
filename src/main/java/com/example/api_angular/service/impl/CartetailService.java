package com.example.api_angular.service.impl;

import com.example.api_angular.model.CartDetail;
import com.example.api_angular.repository.ICartDetailRepository;
import com.example.api_angular.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartetailService implements ICartDetailService {

    @Autowired
    ICartDetailRepository cartDetailRepository;
    @Override
    public Iterable<CartDetail> findAll() {
        return cartDetailRepository.findAll();
    }

    @Override
    public Optional<CartDetail> findById(Long id) {
        return cartDetailRepository.findById(id);
    }

    @Override
    public void save(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void remove(Long id) {
        cartDetailRepository.deleteById(id);
    }
}

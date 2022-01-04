package com.example.api_angular.service.category;


import com.example.api_angular.model.Category;
import com.example.api_angular.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository addressRepository;

    @Override
    public Iterable<Category> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        addressRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        addressRepository.deleteById(id);
    }
}

package com.example.api_angular.repository;



import com.example.api_angular.model.Category;
import com.example.api_angular.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByNameContaining(String firstName, Pageable pageable);

    Boolean existsByName (String name);
    Iterable<Product> findAllByOrderByIdDesc();
}

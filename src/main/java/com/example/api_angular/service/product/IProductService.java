package com.example.api_angular.service.product;



import com.example.api_angular.model.Category;
import com.example.api_angular.model.Product;
import com.example.api_angular.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);
    Iterable<Product> findAll();
    Iterable<Product> findAllByOrderByIdDesc();
    Boolean existsByName (String name);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}

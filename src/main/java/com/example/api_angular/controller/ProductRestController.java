package com.example.api_angular.controller;


import com.example.api_angular.dto.response.ResponMessage;
import com.example.api_angular.model.Category;
import com.example.api_angular.model.Product;
import com.example.api_angular.service.category.ICategoryService;
import com.example.api_angular.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductRestController {


    @Autowired
    IProductService productService;



//    @GetMapping("/home")
//    public ModelAndView listCustomers(Optional<String> search, @PageableDefault(value = 5) Pageable pageable){
//        Page<Product> customers;
//        if(search.isPresent()){
//            customers = productService.findAllByFirstName(search.get(), pageable);
//        }
//
//        else {
//            customers = productService.findAll(pageable);
//        }
//
//        ModelAndView modelAndView = new ModelAndView("/home");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Iterable<Customer>> findAll(){
//        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
//    }
    @GetMapping("/page")
    public ResponseEntity<Page<?>> findAll(@RequestParam ("name") String search, Pageable pageable){
        if (search != ""){
            return new ResponseEntity<>(productService.findAllByNameContaining(search, pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(productService.findAllByOrderByIdDesc(), HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<?> save(@RequestBody Product product) {
      if(productService.existsByName(product.getName())){
            return new ResponseEntity<>(new ResponMessage("no_name"), HttpStatus.OK);
        }
        if(product.getAvatar()==null){
            return new ResponseEntity<>(new ResponMessage("no_avatar"), HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponMessage("create_success"), HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> product1 = productService.findById(id);
        if (!product1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (!product1.get().getName().equals(product.getName())){
            if (productService.existsByName(product.getName())){
                return new ResponseEntity<>(new ResponMessage("no_name"),HttpStatus.OK);
            }
        }

        productService.save(product);
        return new ResponseEntity<>(new ResponMessage("update_success"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(new ResponMessage("delete_success"), HttpStatus.OK);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }



}

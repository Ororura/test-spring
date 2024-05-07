package com.ororura.valorantboosting.controllers;

import com.ororura.valorantboosting.entities.Product;
import com.ororura.valorantboosting.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class MainController {

    private final ProductRepo productRepository;

    @Autowired
    public MainController(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }


    @GetMapping("/product/{id}")
    public Product product(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/product-by-user/{id}")
    public List<Product> productbyuser(@PathVariable int id) {
        return productRepository.findByOwnerId(id);
    }

    @GetMapping("/products/{name}")
    public List<Product> products(@PathVariable String name) {
        return productRepository.findByCategory(name);
    }

    @GetMapping("/find-by-stock/{status}")
    public List<Product> findbystock(@PathVariable boolean status) {
        return productRepository.findByInStock(status);
    }
}

package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    private final UserRepository userRepository;
    private final ProductRepo productRepository;

    @Autowired
    public Controller(UserRepository userRepository, ProductRepo productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/user/{id}")
    public Account account(@PathVariable Long id) {
        Optional<Account> users = userRepository.findById(id);
        return users.orElse(null);
    }

    @GetMapping("/product/{id}")
    public Product product(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @GetMapping("/product-by-user/{id}")
    public List<Product> productbyuser(@PathVariable Long id) {
        return productRepository.findByOwnerId(id);
    }

    @GetMapping("/products/{name}")
    public List<Product> products(@PathVariable String name) {
        return productRepository.findByCategory(name);
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody Account account) {
        userRepository.save(account);
    }

    @GetMapping("/find-by-stock/{status}")
    public List<Product> findbystock(@PathVariable boolean status) {
        return productRepository.findByInStock(status);
    }
}
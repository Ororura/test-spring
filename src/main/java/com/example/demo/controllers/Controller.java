package com.example.demo.controllers;

import com.example.demo.api.Api;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api")
    public String api() {
        return Api.get("https://fakestoreapi.com/products/1");
    }

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/test{id}")
    public User test(@PathVariable int id) {
        Optional<User> users = userRepository.findById(id);
        return users.orElse(null);
    }

    @GetMapping("/product{id}")
    public Product product(@PathVariable int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
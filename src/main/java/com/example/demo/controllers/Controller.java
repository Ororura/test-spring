package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    private final UserRepository userRepository;
    private final ProductRepo productRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Controller(UserRepository userRepository, ProductRepo productRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/user")
    public List<Account> accounts() {
        return userRepository.findAll();
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
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userRepository.save(account);
    }

    @GetMapping("/find-by-stock/{status}")
    public List<Product> findbystock(@PathVariable boolean status) {
        return productRepository.findByInStock(status);
    }

    @GetMapping("/test-auth/{password}")
    public String testAuth(@PathVariable String password) {
        Optional<Account> account = userRepository.findById(6L);
        if (account.isEmpty()) {
            return "User not found!";
        }

        System.out.println("Founded user: " + account.get().getFirstName());

        if (passwordEncoder.matches(password, account.get().getPassword())) {
            return "Success!";
        }

        return "Wrong password!";
    }
}
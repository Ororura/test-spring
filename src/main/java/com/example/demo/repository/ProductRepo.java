package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ProductRepo extends Repository<Product, Long> {
    Optional<Product> findById(int id);
}

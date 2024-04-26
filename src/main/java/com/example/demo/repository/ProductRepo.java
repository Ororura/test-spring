package com.example.demo.repository;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByOwnerId(Long ownerId);

    List<Product> findByCategory(String categoryName);

    List<Product> findByInStock(boolean inStock);
}

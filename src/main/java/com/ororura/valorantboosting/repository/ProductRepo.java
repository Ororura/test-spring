package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByOwnerId(Integer ownerId);

    List<Product> findByCategory(String categoryName);

    List<Product> findByInStock(boolean inStock);
}

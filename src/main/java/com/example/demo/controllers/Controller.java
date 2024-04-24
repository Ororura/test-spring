package com.example.demo.controllers;

import com.example.demo.api.Api;
import com.example.demo.model.Goods;
import com.example.demo.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    private final List<Product> products = new ArrayList<Product>();
    private final ArrayList<Goods> goods = new ArrayList<Goods>();

    @PostConstruct
    public void init() {
        products.add(new Product(1, "Apple", 100, 42));
        products.add(new Product(2, "Banana", 50, 30));
        goods.add(new Goods(goods.toArray().length, "Apple", "Green"));
        goods.add(new Goods(goods.toArray().length, "Juice", "Red"));
    }

    @GetMapping("/api")
    public String api() {
        return Api.get("https://fakestoreapi.com/products/1");
    }

    @GetMapping("/")
    public String index() {
        System.out.println("Hello");
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> products() {
        return products;
    }

    @GetMapping("/goods")
    public ArrayList<Goods> goods() {
        return goods;
    }
}
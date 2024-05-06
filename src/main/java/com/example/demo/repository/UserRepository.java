package com.example.demo.repository;

import com.example.demo.entities.user.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}


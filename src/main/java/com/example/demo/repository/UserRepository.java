package com.example.demo.repository;

import com.example.demo.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Account, Long> {
}


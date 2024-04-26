package com.example.demo.repository;

import com.example.demo.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<Account, Long> {
}


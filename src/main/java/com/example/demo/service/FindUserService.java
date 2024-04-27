package com.example.demo.service;

import com.example.demo.entities.Account;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserService {

    private final UserRepository userRepository;

    @Autowired
    public FindUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Account findById(long id) {
        Optional<Account> user = userRepository.findById(id);
        return user.orElse(null);
    }
}

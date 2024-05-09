package com.ororura.valorantboosting.controllers;

import com.ororura.valorantboosting.entities.Account;
import com.ororura.valorantboosting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class GetUser {

    private final UserRepository userRepository;

    @Autowired
    public GetUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/get-user")
    public Account getUser() {
        Optional<Account> findedUser = this.userRepository.findById(2L);
        if (findedUser.isPresent()) {
            System.out.println(findedUser.get());
            return findedUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
    }
}

package com.ororura.valorantboosting.controllers;

import com.ororura.valorantboosting.entities.User;
import com.ororura.valorantboosting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/get-user")
    public User getUser() {
        Optional<User> findedUser = this.userRepository.findById(2L);
        if (findedUser.isPresent()) {
            System.out.println(findedUser.get());
            return findedUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
    }
}
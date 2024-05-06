package com.example.demo.repository;

import com.example.demo.entities.messages.usersMessages.UsersMessages;
import org.springframework.data.repository.ListCrudRepository;

public interface ChatMessageRepo extends ListCrudRepository<UsersMessages, Long> {
}

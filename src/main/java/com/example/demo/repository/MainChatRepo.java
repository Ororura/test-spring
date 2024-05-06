package com.example.demo.repository;

import com.example.demo.entities.messages.mainChat.MainChat;
import org.springframework.data.repository.ListCrudRepository;

public interface MainChatRepo extends ListCrudRepository<MainChat, Long> {
}

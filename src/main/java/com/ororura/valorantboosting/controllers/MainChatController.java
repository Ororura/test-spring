package com.ororura.valorantboosting.controllers;

import com.ororura.valorantboosting.entities.MainChat;
import com.ororura.valorantboosting.repository.MainChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class MainChatController {
    private final MainChatRepo mainChatRepo;

    @Autowired
    public MainChatController(MainChatRepo mainChatRepo) {
        this.mainChatRepo = mainChatRepo;
    }

    @GetMapping("/main-chat")
    public List<MainChat> getMainChat() {
        return mainChatRepo.findAll();
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public List<MainChat> messages(@Payload MainChat message) {
        message.setTimestamp(Instant.now());
        this.mainChatRepo.save(message);
        return mainChatRepo.findAll();
    }
}

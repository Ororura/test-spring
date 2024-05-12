package com.ororura.valorantboosting.controllers;

import com.ororura.valorantboosting.entities.Messages;
import com.ororura.valorantboosting.repository.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    private final ChatRepo chatRepo;

    @Autowired
    public ChatController(ChatRepo usersMessagesRepo) {
        this.chatRepo = usersMessagesRepo;
    }

    @GetMapping("/users-chat")
    public List<Messages> personalChat() {
        return this.chatRepo.findMessagesBetweenUsers(2L, 1L);
    }

//    @MessageMapping("personal-chat")
//    @SendTo("/topic/personal-chat")
//    public List<UsersMessages> sendMessage(UsersMessages usersMessages) {
//
//    }

//    @MessageMapping("/personal-chat")
//    @SendTo("/topic/personal-chat")
//    public List<Messages> personalChat(@Payload Messages messages) {
//
//    }
}
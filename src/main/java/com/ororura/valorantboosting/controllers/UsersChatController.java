package com.ororura.valorantboosting.controllers;

import com.ororura.valorantboosting.entities.UsersMessages;
import com.ororura.valorantboosting.repository.UsersMessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersChatController {

    private final UsersMessagesRepo usersMessagesRepo;

    @Autowired
    public UsersChatController(UsersMessagesRepo usersMessagesRepo) {
        this.usersMessagesRepo = usersMessagesRepo;
    }

    @GetMapping("/users-chat")
    public List<UsersMessages> personalChat() {
        return this.usersMessagesRepo.findBySenderIdOrReceiverIdOrderBySentAtDesc(1, 2);
    }

    @MessageMapping("personal-chat")
    @SendTo("/topic/personal-chat")
    public List<UsersMessages> sendMessage(UsersMessages usersMessages) {
        usersMessagesRepo.save(usersMessages);
        return this.usersMessagesRepo.findBySenderIdOrReceiverIdOrderBySentAtDesc(usersMessages.getReceiver().getId(), usersMessages.getSender().getId());
    }

}

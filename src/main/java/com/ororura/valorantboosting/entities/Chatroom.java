package com.ororura.valorantboosting.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "chat_room")
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('chat_room_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiver;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Messages messages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public Messages getUsersMessages() {
        return messages;
    }

    public void setUsersMessages(Messages messages) {
        this.messages = messages;
    }
}
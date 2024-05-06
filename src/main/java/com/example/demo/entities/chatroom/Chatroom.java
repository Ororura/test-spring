package com.example.demo.entities.chatroom;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Entity
@Table(name = "chat_room")
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('chat_room_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "senderid", nullable = false)
    private UUID senderid;

    @Column(name = "recipientid", nullable = false)
    private UUID recipientid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getSenderid() {
        return senderid;
    }

    public void setSenderid(UUID senderid) {
        this.senderid = senderid;
    }

    public UUID getRecipientid() {
        return recipientid;
    }

    public void setRecipientid(UUID recipientid) {
        this.recipientid = recipientid;
    }

}
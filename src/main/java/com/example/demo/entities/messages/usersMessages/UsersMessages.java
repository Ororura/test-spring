package com.example.demo.entities.messages.usersMessages;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users_messages")
public class UsersMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('chat_message_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "chatid", nullable = false)
    private UUID chatid;

    @Column(name = "senderid", nullable = false)
    private UUID senderid;

    @Column(name = "recipientid", nullable = false)
    private UUID recipientid;

    @Column(name = "sendername", nullable = false, length = 50)
    private String sendername;

    @Column(name = "recipientname", nullable = false, length = 50)
    private String recipientname;

    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "\"timestamp\"", nullable = false)
    private Instant timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getChatid() {
        return chatid;
    }

    public void setChatid(UUID chatid) {
        this.chatid = chatid;
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

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getRecipientname() {
        return recipientname;
    }

    public void setRecipientname(String recipientname) {
        this.recipientname = recipientname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

}
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

    @Column(name = "senderid", nullable = false)
    private Integer senderid;

    @Column(name = "recipientid", nullable = false)
    private Integer recipientid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getRecipientid() {
        return recipientid;
    }

    public void setRecipientid(Integer recipientid) {
        this.recipientid = recipientid;
    }

}
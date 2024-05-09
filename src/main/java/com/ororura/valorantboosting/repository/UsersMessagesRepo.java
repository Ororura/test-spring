package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.UsersMessages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersMessagesRepo extends JpaRepository<UsersMessages, Integer> {
    List<UsersMessages> findBySenderIdOrReceiverIdOrderBySentAtDesc(Integer senderId, Integer receiverId);
}

package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Messages, Long> {
    @Query("SELECT m FROM Messages m WHERE (m.sender.id = :userId1 AND m.recipient.id = :userId2) OR (m.sender.id = :userId2 AND m.recipient.id = :userId1) ORDER BY m.timestamp")
    List<Messages> findMessagesBetweenUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);
}

package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersMessagesRepo extends JpaRepository<Messages, Integer> {
}

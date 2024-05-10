package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.Messages;
import org.springframework.data.repository.ListCrudRepository;

public interface ChatMessageRepo extends ListCrudRepository<Messages, Long> {
}

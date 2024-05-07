package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.UsersMessages;
import org.springframework.data.repository.ListCrudRepository;

public interface ChatMessageRepo extends ListCrudRepository<UsersMessages, Long> {
}

package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}


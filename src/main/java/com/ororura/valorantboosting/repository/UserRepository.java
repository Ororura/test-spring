package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}


package com.ororura.valorantboosting.repository;

import com.ororura.valorantboosting.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Account, Long> {
}


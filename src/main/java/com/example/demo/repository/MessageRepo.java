package com.example.demo.repository;

import com.example.demo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface MessageRepo extends ListCrudRepository<Message, Long> {
}

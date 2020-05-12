package com.gomezortiz.templateapp.repository;

import com.gomezortiz.templateapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    public Optional<Message> findByCode(String code);
}

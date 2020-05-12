package com.gomezortiz.templateapp.controller;

import com.gomezortiz.templateapp.model.Message;
import com.gomezortiz.templateapp.repository.MessageRepository;
import com.gomezortiz.templateapp.service.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping({"", "/"})
@RequiredArgsConstructor
public class HomeController {

    private final MessageRepository repository;
    private final NotificationSender sender;

    @Value("${welcome.message}")
    private String message;

    @GetMapping
    public String welcome() {
        Optional<Message> welcomeMessage = repository.findByCode("welcome.message");
        if(welcomeMessage.isPresent()) {
            repository.delete(welcomeMessage.get());
        }
        sender.send(message.contains("Docker") ? "docker" : "default");
        return repository.save(new Message(UUID.randomUUID(), "welcome.message", message)).text();
    }
}

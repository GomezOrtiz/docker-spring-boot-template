package com.gomezortiz.templateapp.service;

import com.gomezortiz.templateapp.config.RabbitMqSchema;
import com.gomezortiz.templateapp.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class NotificationSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String source) {
        rabbitTemplate.convertAndSend(
                RabbitMqSchema.NOTIFICATION_EXCHANGE, "",
                new Notification(source, LocalDate.now()));
    }
}

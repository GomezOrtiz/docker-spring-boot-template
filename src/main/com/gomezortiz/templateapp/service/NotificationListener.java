package com.gomezortiz.templateapp.service;

import com.gomezortiz.templateapp.config.RabbitMqSchema;
import com.gomezortiz.templateapp.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationListener {

    @RabbitListener(queues = RabbitMqSchema.NOTIFICATION_QUEUE)
    public void listen(Notification notification) {
        log.info("New notification received: {}", notification);
    }
}

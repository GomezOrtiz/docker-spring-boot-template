package com.gomezortiz.templateapp.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqSchema {

    public static final String NOTIFICATION_EXCHANGE = "x.notification";
    public static final String NOTIFICATION_QUEUE = "q.notification";

    @Bean
    public Declarables createCommandsSchema() {

        FanoutExchange exchange = new FanoutExchange(NOTIFICATION_EXCHANGE, true, false, null);
        Queue queue = QueueBuilder.durable(NOTIFICATION_QUEUE).build();

        return new Declarables(
                exchange, queue,
                BindingBuilder.bind(queue).to(exchange)
        );
    }
}

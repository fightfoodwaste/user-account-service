package com.fightfoodwaste.useraccountservice.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class MessagingConfig {
    @Bean
    public Channel rabbitMQChannel() throws IOException, TimeoutException {
        /*ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(System.getenv("RABBITMQ_HOST"));
        connectionFactory.setPort(Integer.parseInt(System.getenv("RABBITMQ_PORT")));
        connectionFactory.setUsername(System.getenv("RABBITMQ_USERNAME"));
        connectionFactory.setPassword(System.getenv("RABBITMQ_PASSWORD"));*/
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(Integer.parseInt("5672"));
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        Connection connection = connectionFactory.newConnection();
        return connection.createChannel();
    }
}

package com.ibm.kafkaspringcloudstreampoc.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Supplier;

@Service
public class KafkaStringProducer {

    @Bean
    public Supplier<String> sendMessages() {
        return () -> String.format("I will send a random id every second. Id: %s", UUID.randomUUID());
    }
}
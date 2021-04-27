package com.ibm.kafkaspringcloudstreampoc.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Supplier;

@Service
@Slf4j
public class KafkaStringProducer {

    @Bean
    public Supplier<String> produceMessages() {
        return this::logAndSend;
    }

    private String logAndSend() {
        UUID uuid = UUID.randomUUID();
        log.info("Sending random id: {}", UUID.randomUUID());
        return uuid.toString();
    }
}
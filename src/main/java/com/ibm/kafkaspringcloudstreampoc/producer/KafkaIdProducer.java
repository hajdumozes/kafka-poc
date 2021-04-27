package com.ibm.kafkaspringcloudstreampoc.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Supplier;

@Component
@Slf4j
public class KafkaIdProducer {

    @Bean
    public Supplier<UUID> produceMessages() {
        return this::logAndSend;
    }

    private UUID logAndSend() {
        UUID uuid = UUID.randomUUID();
        log.info("Sending random id: {}", UUID.randomUUID());
        return uuid;
    }
}
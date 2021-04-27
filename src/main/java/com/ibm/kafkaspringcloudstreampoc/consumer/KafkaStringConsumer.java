package com.ibm.kafkaspringcloudstreampoc.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class KafkaStringConsumer {

    @Bean
    public Consumer<String> processMessages() {
        return message -> log.info("Received message: {}", message);
    }

}

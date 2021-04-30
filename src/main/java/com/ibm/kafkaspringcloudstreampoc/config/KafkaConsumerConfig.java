package com.ibm.kafkaspringcloudstreampoc.config;

import com.ibm.kafkaspringcloudstreampoc.service.consumer.KafkaRequestConsumer;
import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class KafkaConsumerConfig {
    KafkaRequestConsumer kafkaRequestConsumer;

    @Bean
    public Consumer<Request> consumeMessages() {
        return kafkaRequestConsumer;
    }
}

package com.ibm.kafkaspringcloudstreampoc.config;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import com.ibm.kafkaspringcloudstreampoc.service.processor.KafkaIdProcessor;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class KafkaProcessorConfig {
    KafkaIdProcessor kafkaIdProcessor;

    @Bean
    public Function<UUID, Request> processMessages() {
        return kafkaIdProcessor;
    }
}

package com.ibm.kafkaspringcloudstreampoc.config;

import com.ibm.kafkaspringcloudstreampoc.service.producer.KafkaIdProducer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.UUID;
import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaProducerConfig {
    KafkaIdProducer kafkaIdProducer;
    Sinks.Many<UUID> uuidSink;

    @Bean
    Supplier<Flux<UUID>> produceMessagesReactively() {
        return kafkaIdProducer.apply(uuidSink);
    }
}

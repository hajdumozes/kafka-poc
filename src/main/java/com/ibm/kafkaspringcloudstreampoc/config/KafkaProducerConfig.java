package com.ibm.kafkaspringcloudstreampoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public Sinks.Many<UUID> uuidSink() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    Supplier<Flux<UUID>> produceMessages(Sinks.Many<UUID> uuidSink) {
        return uuidSink::asFlux;
    }
}

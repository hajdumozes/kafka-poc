package com.ibm.kafkaspringcloudstreampoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Sinks;

import java.util.UUID;

@Configuration
public class SinkConfig {

    @Bean
    public Sinks.Many<UUID> uuidSink() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }
}

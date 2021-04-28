package com.ibm.kafkaspringcloudstreampoc.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.UUID;
import java.util.function.Supplier;

@EnableScheduling
@Component
@Slf4j
public class ScheduledProducer {
    private final static Sinks.Many<UUID> SINK = Sinks.many().unicast().onBackpressureBuffer();

    @Scheduled(initialDelay = 2000, fixedDelay = 4000)
    public void addToFlux() {
        UUID uuid = UUID.randomUUID();
        log.info("Added id ({}) to reactive queue", uuid);
        SINK.tryEmitNext(uuid);
    }

    @Bean
    public Supplier<Flux<UUID>> produceMessagesReactively() {
        return SINK::asFlux;
    }
}

package com.ibm.kafkaspringcloudstreampoc.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ScheduledProducer {
    private final Sinks.Many<UUID> sink = Sinks.many().unicast().onBackpressureBuffer();

    @Scheduled(initialDelay = 2000, fixedDelay = 4000)
    public void addToFlux() {
        UUID uuid = UUID.randomUUID();
        log.info("Added id ({}) to reactive queue", uuid);
        sink.tryEmitNext(uuid);
    }

    @Bean
    public Supplier<Flux<UUID>> produceMessagesReactively() {
        return sink::asFlux;
    }
}

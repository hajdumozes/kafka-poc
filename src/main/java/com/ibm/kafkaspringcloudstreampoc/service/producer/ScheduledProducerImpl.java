package com.ibm.kafkaspringcloudstreampoc.service.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
class ScheduledProducerImpl implements ScheduledProducer {
    Sinks.Many<UUID> uuidSink;

    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
    @Override
    public void addToFlux() {
        UUID uuid = UUID.randomUUID();
        uuidSink.tryEmitNext(uuid);
        log.info("Added id ({}) to scheduled queue", uuid);
    }
}

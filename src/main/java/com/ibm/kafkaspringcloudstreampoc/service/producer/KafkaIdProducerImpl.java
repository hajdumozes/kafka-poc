package com.ibm.kafkaspringcloudstreampoc.service.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
class KafkaIdProducerImpl implements KafkaIdProducer {
    Sinks.Many<UUID> uuidSink;

    @Override
    public void produce(UUID uuid) {
        uuidSink.tryEmitNext(uuid);
        log(uuid);
    }

    private void log(UUID uuid) {
        log.info("Added id ({}) to non-reactive queue", uuid);
    }
}

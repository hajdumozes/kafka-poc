package com.ibm.kafkaspringcloudstreampoc.service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.UUID;
import java.util.function.Supplier;

@Component
@Slf4j
class KafkaIdProducerImpl implements KafkaIdProducer {

    @Override
    public Supplier<Flux<UUID>> apply(Sinks.Many<UUID> uuidSink) {
        return uuidSink::asFlux;
    }
}

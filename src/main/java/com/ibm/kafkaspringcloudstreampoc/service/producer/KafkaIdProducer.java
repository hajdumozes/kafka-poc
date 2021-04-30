package com.ibm.kafkaspringcloudstreampoc.service.producer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public interface KafkaIdProducer extends Function<Sinks.Many<UUID>, Supplier<Flux<UUID>>> {
}

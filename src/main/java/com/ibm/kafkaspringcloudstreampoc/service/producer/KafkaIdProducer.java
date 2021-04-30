package com.ibm.kafkaspringcloudstreampoc.service.producer;

import java.util.UUID;

public interface KafkaIdProducer {
    void produce(UUID uuid);
}

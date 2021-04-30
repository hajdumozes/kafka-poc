package com.ibm.kafkaspringcloudstreampoc.service.consumer;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;

import java.util.function.Consumer;

public interface KafkaRequestConsumer extends Consumer<Request> {
}

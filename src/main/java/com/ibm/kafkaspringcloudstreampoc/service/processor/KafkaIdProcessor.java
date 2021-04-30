package com.ibm.kafkaspringcloudstreampoc.service.processor;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;

import java.util.UUID;
import java.util.function.Function;

public interface KafkaIdProcessor extends Function<UUID, Request> {
}

package com.ibm.kafkaspringcloudstreampoc.processor;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
@Slf4j
public class KafkaIdProcessor {

    @Bean
    public Function<UUID, Request> processMessages() {
        return this::from;
    }

    private Request from(UUID uuid) {
        Request request = new Request();
        request.setId(uuid);
        request.setStatus(Request.Status.DONE);
        log.info("Mapped id({}) into {}", uuid, request);
        return request;
    }
}

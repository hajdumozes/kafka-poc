package com.ibm.kafkaspringcloudstreampoc.service.processor;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
class KafkaIdProcessorImpl implements KafkaIdProcessor {

    @Override
    public Request apply(UUID uuid) {
        Request request = of(uuid);
        logTransformation(uuid, request);
        return request;
    }

    private Request of(UUID uuid) {
        Request request = new Request();
        request.setId(uuid);
        request.setStatus(Request.Status.DONE);
        return request;
    }

    private void logTransformation(UUID uuid, Request request) {
        log.info("Mapped id({}) into {}", uuid, request);

    }
}

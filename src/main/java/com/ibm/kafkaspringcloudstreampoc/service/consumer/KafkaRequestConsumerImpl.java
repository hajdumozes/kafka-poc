package com.ibm.kafkaspringcloudstreampoc.service.consumer;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("consumeMessages")
@Slf4j
class KafkaRequestConsumerImpl implements KafkaRequestConsumer {

    @Override
    public void accept(Request request) {
        log.info("Received request: {}", request.toString());
    }
}

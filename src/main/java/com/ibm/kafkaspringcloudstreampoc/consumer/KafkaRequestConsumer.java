package com.ibm.kafkaspringcloudstreampoc.consumer;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class KafkaRequestConsumer {

    @Bean
    public Consumer<Request> consumeMessages() {
        return request -> log.info("Received request: {}", request.toString());
    }

}

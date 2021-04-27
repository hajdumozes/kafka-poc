package com.ibm.kafkaspringcloudstreampoc.consumer;

import com.ibm.kafkaspringcloudstreampoc.domain.Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class KafkaConsumer {

    @Bean
    public Consumer<Request> consumeMessages() {
        return request -> log.info("Received request: {}", request.toString());
    }

}

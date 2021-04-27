## Kafka Spring Cloud Stream POC

### Description
A simple app, that sets an example how to use and consume messages with spring cloud stream (kafka implementation), including strings and pojos.

### How to use
- you need a running kafka instance
- you need to create your own topics with kafka terminal
eg.: `bin/kafka-topics.sh --create --topic kafka-test --bootstrap-server localhost:9093`
- set environment variables required in application.yml
- check application.yml and set your functions/bindings

### Configuration

Configs could be done in the application.yml file.
- you need to list your functions in `spring.cloud.stream.function.definition`. 
    - you can separate them with `;` (without space!), eg.: `foo;bar`
- you need to config your functions in the following way: 
    `spring.cloud.stream.function.bindings.{YOUR_METHOD_NAME}-{out/in}-0: {YOUR_BINDING_NAME}`
- you need to config your bindings in the following way: 
    `spring.cloud.stream.bindings.{YOUR_BINDING_NAME}.destination: {DESIRED_TOPIC}`

### Default environment variables

- BROKERS: host + port of the kafka instance
- KAFKA_STRING_TOPIC: kafka topic for ids
- KAFKA_POJO_TOPIC: kafka topic for requests

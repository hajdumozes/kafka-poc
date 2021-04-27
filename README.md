## Kafka Spring Cloud Stream POC

### Configuration

Configs could be done in the application.yml file.
- in the function bindings add/replace your method name, which sends the data, and the value should be a binding.
- in the bindings, set the destination to your topic. Note that that binding should be the same as in the function.

### Env vars

- BROKERS: host + port
- TOPIC: kafka topic

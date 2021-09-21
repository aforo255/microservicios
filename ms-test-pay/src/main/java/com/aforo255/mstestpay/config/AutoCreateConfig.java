package com.aforo255.mstestpay.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AutoCreateConfig {

  @Bean
  public NewTopic payEvent() {

    return TopicBuilder.name("operation-events")
        .partitions(3)
        .replicas(1)
        .build();
  }
}

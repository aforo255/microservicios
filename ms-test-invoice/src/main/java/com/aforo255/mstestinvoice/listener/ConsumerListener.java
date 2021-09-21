package com.aforo255.mstestinvoice.listener;

import com.aforo255.mstestinvoice.service.OperationsEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ConsumerListener {

  private final OperationsEvents operationsEvents;

  @KafkaListener(topics = {"operation-events"})
  public void onMessage(ConsumerRecord<Integer, String> consumerRecord)
      throws JsonProcessingException {
    log.info("############# Microservice Invoice #############");
    log.info("ConsumerRecord: {}", consumerRecord.value());
    operationsEvents.processTransactionEvent(consumerRecord);
  }

}

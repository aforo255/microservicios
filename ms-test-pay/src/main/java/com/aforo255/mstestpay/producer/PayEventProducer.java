package com.aforo255.mstestpay.producer;

import com.aforo255.mstestpay.dto.OperationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
@RequiredArgsConstructor
public class PayEventProducer {

  @Value("${spring.kafka.template.default-topic}")
  private String topicName;

  private final KafkaTemplate<Integer, String> kafkaTemplate;
  private final ObjectMapper objectMapper;


  public ListenableFuture<SendResult<Integer, String>> sendPayEvent(OperationDto operationDto)
      throws JsonProcessingException {

    Integer key = operationDto.getOperationId().intValue();
    String value = objectMapper.writeValueAsString(operationDto);

    ProducerRecord<Integer, String> producerRecord = this.buildProducerRecord(key, value,
        topicName);
    ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(
        producerRecord);

    listenableFuture.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onFailure(Throwable ex) {
        log.error("Error enviando el mensaje al topic {}", topicName);
      }

      @Override
      public void onSuccess(SendResult<Integer, String> result) {
        log.info("Se envío el mensaje exitosamente - {} ", topicName);
      }
    });

    return listenableFuture;
  }


  private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value,
      String topic) {
    List<Header> recordHeaders = List.of(
        new RecordHeader("deposit-event-source", "scanner".getBytes()));
    return new ProducerRecord<>(topic, null, key, value, recordHeaders);
  }

}

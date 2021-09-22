package com.aforo255.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.aforo255.service.TransactionsEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Component
//@Slf4j
public class ConsumerListener {
	
	private Logger log =  org.slf4j.LoggerFactory.getLogger(ConsumerListener.class);
	
	@Autowired
	private TransactionsEvents _transactionEvents;

	@KafkaListener(topics = {"transaction-events"})
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info("*************** MICROSERVICE HISTORICAL *******************");
		log.info("ConsumerRecord : {}", consumerRecord.value());
			_transactionEvents.processTransactionEvent(consumerRecord);
	}
}

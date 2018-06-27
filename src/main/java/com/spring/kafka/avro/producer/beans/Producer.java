package com.spring.kafka.avro.producer.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.spring.kafka.avro.producer.beans.MongoTransactions;

public class Producer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

	public void produce(KafkaTemplate<String, MongoTransactions> template, String avroTopicName, MongoTransactions payload) {
		
		LOGGER.info("sending avro payload : " + payload.toString() + " to the topic : " + avroTopicName);
		template.send(avroTopicName, payload);
		
	}

}

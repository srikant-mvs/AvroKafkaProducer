package com.spring.kafka.avro.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.avro.producer.beans.Producer;
import com.spring.kafka.avro.producer.beans.MongoTransactions;


@RestController
public class AvroProducerRestEndPoint {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AvroProducerRestEndPoint.class);
	
	@Value("${kafka.topic.name}")
	  private String avroTopicName;
	
	@Autowired
    private KafkaTemplate<String, MongoTransactions> template;
	
	@RequestMapping(value="/produceAvroMessages", method = RequestMethod.POST)
	@ResponseBody
	public String sendAvroPayloadToKafka(@RequestBody MongoTransactions payload) {
		
		Producer producer = new Producer();		
		producer.produce(template, avroTopicName, payload);
		
		LOGGER.info("Payload Successfully sent to Kafka!");
	    
	    return "SUCCESS";
	   }

}

package com.spring.kafka.avro.producer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class AvroKafkaMainProducerApp implements CommandLineRunner {
	
	public static Logger logger = LoggerFactory.getLogger(AvroKafkaMainProducerApp.class);
	
	@Value("${kafka.topic.name}")
	  private String kafkaTopicName;
	
	//@Autowired
    //private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) {
		SpringApplication.run(AvroKafkaMainProducerApp.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		//this.template.send(kafkaTopicName, "");
        //latch.await(60, TimeUnit.SECONDS);
		logger.info("Nothing is getting printed here. Use the RESTEndpoints");
    }

}

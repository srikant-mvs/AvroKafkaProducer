package com.spring.kafka.avro.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldRestController {
	
	@RequestMapping("/")
	public String sayHello() {
	      return "Running a Simple Avro Producer in Kafka!!";
	   }

}

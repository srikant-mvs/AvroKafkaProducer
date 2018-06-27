package com.spring.kafka.avro.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.spring.kafka.avro.producer.beans.Producer;
import com.spring.kafka.avro.producer.beans.MongoTransactions;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;



@Configuration
public class AvroKafkaConfigs {
	
	@Value("${kafka.bootstrap-servers}")
	  private String bootstrapServers;
	
	@Value("${kafka.schema-registry-url}")
	private String schemaRegistryUrl;
	
	@Bean
	  public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,	KafkaAvroSerializer.class);
		props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "AvroKafkaProducer");
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 8192);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 0);
		props.put(ProducerConfig.ACKS_CONFIG, "0");
		    
		return props;
	}

	@Bean
	public ProducerFactory<String, MongoTransactions> producerFactory() {
		return new DefaultKafkaProducerFactory<String, MongoTransactions>(producerConfigs());
	}
	
	@Bean
	public KafkaTemplate<String,MongoTransactions> kafkaTemplate( ) {
		return new KafkaTemplate<String, MongoTransactions>(producerFactory());
	}
	
	@Bean
	public Producer producer() {
		return new Producer();
		
	}

}

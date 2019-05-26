package com.org.rating.backend.jms.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.org.rating.backend.events.entity.NewReviewAdded;

@EnableKafka
@Configuration
public class KConsumerConfiguration {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServers;

	@Value("${kafka.group.product-rating-service}")
	private String groupId;

	@Bean
	public Map<String, Object> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return props;
	}

	@Bean
	public ConsumerFactory<String, NewReviewAdded> NewReviewAddedCF() {
		return new DefaultKafkaConsumerFactory<>(
			consumerFactory(),
			new StringDeserializer(),
			new JsonDeserializer<NewReviewAdded>(NewReviewAdded.class));
	}

	@Bean("kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, NewReviewAdded> kafkaListenerOrderAcceptConfirmedContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, NewReviewAdded> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(NewReviewAddedCF());
		return factory;
	}

	@Bean
	public KafkaListenerErrorHandler errorHandler() {
		return new KErrorHandler();
	}
}

package com.org.rating.backend.jms.consumer;

import java.util.Objects;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.org.rating.backend.events.entity.ExploitationReviewEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Anvi P
 *
 */
@Slf4j
public class KEventConsumer {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@KafkaListener(topics = ExploitationReviewEvent.EVENT_NAME, errorHandler = "errorHandler", containerFactory = "kafkaListenerContainerFactory")
	public void listenOrderBeansValidatedTopic(@Payload(required = false) ExploitationReviewEvent exploitReviewEvent) {

		if (Objects.isNull(exploitReviewEvent)) {
			return;
		}

		MDC.put("eventName", ExploitationReviewEvent.EVENT_NAME);
		MDC.put("referenceId", exploitReviewEvent.getReviewId());
		log.info("Order ::Received Messasge in default group: " + exploitReviewEvent.getReviewId());
		log.info(ExploitationReviewEvent.EVENT_NAME + " | " + Thread.currentThread().getName());
		eventPublisher.publishEvent(exploitReviewEvent);

		MDC.clear();
	}

}

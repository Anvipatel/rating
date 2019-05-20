package com.org.revrep.backend.jms.consumer;

import java.util.Objects;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.org.revrep.backend.events.entity.ExploitationReviewEvent;

/**
 * @author Anvi P
 *
 */
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
		System.out.println("Order ::Received Messasge in default group: " + exploitReviewEvent.getReviewId());
		System.out.println(ExploitationReviewEvent.EVENT_NAME + " | " + Thread.currentThread().getName());
		eventPublisher.publishEvent(exploitReviewEvent);

		MDC.clear();
	}

}

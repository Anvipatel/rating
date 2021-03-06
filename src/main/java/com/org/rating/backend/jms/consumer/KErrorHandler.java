package com.org.rating.backend.jms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

/**
 * @author Anvi P
 *
 */
public class KErrorHandler implements KafkaListenerErrorHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(KErrorHandler.class);
	
	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException e) throws Exception {
		LOGGER.info("Handling error for -Message: {}, -Headers [{}], -exception: {}",message.getPayload(), message.getHeaders(), e.getMessage());
		return null;
	}

}

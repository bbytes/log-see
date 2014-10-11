package com.bbytes.logsee.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogDataGenerator implements
    ApplicationListener<BrokerAvailabilityEvent> {

	private static final Logger log = LoggerFactory
			.getLogger(LogDataGenerator.class);
	
    private final MessageSendingOperations<String> messagingTemplate;

    @Autowired
    public LogDataGenerator(
        final MessageSendingOperations<String> messagingTemplate) {
       this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onApplicationEvent(final BrokerAvailabilityEvent event) {

    }

    @Scheduled(fixedDelay = 100)
    public void sendDataUpdates() {
    	log.info("Random no generated " + new Random().nextInt(100));
    }
    
}
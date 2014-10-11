package com.bbytes.logsee.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@EnableScheduling
@Configuration
@ComponentScan("com.bbytes.logsee")
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends
		AbstractWebSocketMessageBrokerConfigurer {

	private static final Logger log = LoggerFactory
			.getLogger(WebSocketConfiguration.class);

	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		registry.addEndpoint("/logview").withSockJS();
	}

	@Override
	public void configureClientInboundChannel(
			ChannelRegistration channelRegistration) {
		channelRegistration.taskExecutor().corePoolSize(4).maxPoolSize(8);
	}

	@Override
	public void configureClientOutboundChannel(
			ChannelRegistration channelRegistration) {
		channelRegistration.taskExecutor().corePoolSize(4).maxPoolSize(8);
	}

	@Override
	public void configureMessageBroker(final MessageBrokerRegistry registry) {
		registry.enableStompBrokerRelay("/topic/", "/queue/")
				.setRelayHost("127.0.0.1").setAutoStartup(true);
	}

}

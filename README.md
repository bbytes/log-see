log-see
=========

Web Log viewer for log4j with spring amqp appender 

Installation
--------------

```sh
  mvn clean install
  mvn jetty:run
```




URL to access app: 
--------------
```sh
http://0.0.0.0:8080/logsee/
```

Screenshot
--------------

[LogSee-1](http://i.imgur.com/GCncUQi.png?1)


Log4j Appender xml
--------------

```sh
	<appender name="amqp"
		class="org.springframework.amqp.rabbit.log4j.AmqpAppender">
		<param name="host" value="127.0.0.1" />
		<param name="port" value="5672" />
		<param name="virtualHost" value="/" />
		<param name="username" value="guest" />
		<param name="password" value="guest" />
		<param name="ExchangeName" value="amq.topic" />
		<param name="ExchangeType" value="topic" />
		<param name="RoutingKeyPattern" value="log.logsee" />
		<param name="ApplicationId" value="log-see" />
		<param name="contentType" value="text/plain" />
		<param name="senderPoolSize" value="2" />
		<param name="maxSenderRetries" value="30" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="%-5p %c{1} - %m%n" />
		</layout>
	</appender>
	
    <logger name="org.springframework.amqp">
              <level value="OFF"/>
    </logger>
```

Messaging Layer
---------------
The project uses rabbitmq running in localhost for messaging . We need to have stomp plugin enabled in rabbitmq.

The STOMP adapter is included in the RabbitMQ distribution. To enable it, use rabbitmq-plugins:


```sh
rabbitmq-plugins enable rabbitmq_stomp
```




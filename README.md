log-see
=========

Web lLog viewer for log4j with spring amqp appender 

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


Messaging Layer
---------------
The project uses rabbitmq running in localhost for messaging . We need to have stomp plugin enabled in rabbitmq.

The STOMP adapter is included in the RabbitMQ distribution. To enable it, use rabbitmq-plugins:


```sh
rabbitmq-plugins enable rabbitmq_stomp
```




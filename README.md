# Kafka Intro

### first
        <!-- kafka dependency -->
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>

### second

~~~xml
spring.kafka.consumer.group-id=kafka-intro
spring.kafka.bootstrap-servers= localhost:902
~~~


### extend
> windows start kafka

start zookeeper server
>bin\windows\zookeeper-server-start.bat config\zookeeper.properties

start kafka server
> bin\windows\kafka-server-start.bat config\server.properties

create topic
>bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic1

show topic list
>bin\windows\kafka-topics.bat --list --zookeeper localhost:2181 

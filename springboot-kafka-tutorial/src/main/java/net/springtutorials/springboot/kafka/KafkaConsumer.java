package net.springtutorials.springboot.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = {"anime","movies","sanatan"},groupId = "myGroup")
    public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        LOGGER.info("Message Received : {} from topic {}",message,topic);
    }





}

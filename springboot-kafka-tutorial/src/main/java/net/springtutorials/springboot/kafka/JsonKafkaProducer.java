package net.springtutorials.springboot.kafka;

import net.springtutorials.springboot.dto.DataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    private KafkaTemplate<String, DataDto> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, DataDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(DataDto dto){
        LOGGER.info("Message Sent : {}", dto.toString());

        Message<DataDto> message = MessageBuilder.withPayload(dto)
                                    .setHeader(KafkaHeaders.TOPIC,"anime")
                                    .build();

        kafkaTemplate.send(message);

    }
}

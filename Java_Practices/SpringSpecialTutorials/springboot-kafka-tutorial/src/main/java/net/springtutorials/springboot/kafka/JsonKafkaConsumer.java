package net.springtutorials.springboot.kafka;


import net.springtutorials.springboot.dto.DataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "data",groupId = "myGroup")
    public void consume(DataDto dto){
        LOGGER.info("Data Consumed : {}",dto.toString());
    }
}

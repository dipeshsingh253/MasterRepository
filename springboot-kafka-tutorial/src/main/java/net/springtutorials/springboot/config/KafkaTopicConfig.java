package net.springtutorials.springboot.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic animeTopic(){
        return TopicBuilder
                .name("anime")
                .build();
    }


    @Bean
    public NewTopic moviesTopic(){
        return TopicBuilder
                .name("movies")
                .build();
    }


    @Bean
    public NewTopic sanatanTopic(){
        return TopicBuilder
                .name("sanatan")
                .build();
    }

}

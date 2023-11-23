package net.springtutorials.springboot.controller;


import net.springtutorials.springboot.dto.DataDto;
import net.springtutorials.springboot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    /**
     * uri : http:localhost:8080/api/v1/kafka/publish?message=naruto
     * @param message Message to be published on kafka broker
     * @return response message
     */
    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){

        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent to the topic");
    }


    /**
     * uri : http:localhost:8080/api/v1/kafka/publish/topic?message=message
     * @param topic topic to message publish on
     * @param message message to published
     * @return response message
     */
    @GetMapping("/publish/{topic}")
    public ResponseEntity<String> publishMessageToTopic(@PathVariable("topic") String topic, @RequestParam("message") String message){

        kafkaProducer.sendMessageToTopic(topic,message);
        return ResponseEntity.ok("Message sent to topic "+topic);

    }


//    @GetMapping("/getdata")
//    public ResponseEntity<List<DataDto>> getData(){
//        return ResponseEntity.ok(List.of(
//                new DataDto("Dipesh", "Java SDE"),
//                new DataDto("Krish", "Java SDE"),
//                new DataDto("Sidharth", "Java SDE"),
//                new DataDto("Jasmik", "Java SDE"),
//                new DataDto("Mohit", "Java SDE"),
//                new DataDto("Mayuri", "Java SDE")
//        ));
//    }

    @GetMapping("/getnumdata")
    public ResponseEntity<List<Integer>> getNumData(){
        return ResponseEntity.ok(List.of(1,2,3,4,5,6,7,8,9,0));
    }

}

package org.example.kafkaconsumer.service.serviceImpl;

import org.example.kafkaconsumer.service.KafkaConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @KafkaListener(topics = "message-from-producer", groupId = "consumer-group")
    public void readMessage(String message){
        System.out.println("Полученное сообщение в верхнем регистре: " + message.toUpperCase());
    }


}


package org.example.kafkaproducer.controllers;


import org.example.kafkaproducer.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0.1/kafka")
public class ProducerController {

    private final KafkaProducerService service;

    @Autowired
    public ProducerController(KafkaProducerService service) {
        this.service = service;
    }


    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        service.sendMessage(message);
        return ResponseEntity.ok().build();
    }


}

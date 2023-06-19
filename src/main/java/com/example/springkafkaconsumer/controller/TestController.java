package com.example.springkafkaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "send/{message}")
    public ResponseEntity<?> send(@PathVariable String message){
        kafkaTemplate.send("topic-1", "Envio de: " + message);
        return ResponseEntity.ok().build();
    }
}

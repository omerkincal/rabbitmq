package org.omarkincal.rabbitmq.controller;

import org.omarkincal.rabbitmq.dto.User;
import org.omarkincal.rabbitmq.publisher.RabbitMQJsonProducer;
import org.omarkincal.rabbitmq.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class JsonMessageController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public JsonMessageController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }


    @PostMapping("publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ...");
    }


}

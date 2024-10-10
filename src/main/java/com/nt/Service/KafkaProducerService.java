package com.nt.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.Entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, User> kafkaUserTemplate;
    private final String topic;
    public KafkaProducerService(KafkaTemplate<String, User> kafkaUserTemplate, @Value("${kafka.topic}") String topic) {
        this.kafkaUserTemplate = kafkaUserTemplate;
        this.topic = topic;
    }

    public void sendMessage(User user) {
        System.out.println("Initial Flow to send data");
        System.out.println("Sending data: " + user);
        kafkaUserTemplate.send(topic, user);
    }
}

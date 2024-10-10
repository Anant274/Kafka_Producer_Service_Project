package com.nt.Controller;

import com.nt.Entity.User;
import com.nt.Repository.UserRepository;
import com.nt.Service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaUserController {
    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sendUser")
    public String sendUser(@RequestBody User user) {
        System.out.println("Starting flow");
        userRepository.save(user);
        System.out.println("data saved");
        producerService.sendMessage(user);
        return "User data sent!";
    }
}


package com.ksr.controller;

import com.ksr.messaging.Greeting;
import com.ksr.messaging.RoomShareMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/reserve")
    @SendTo("/topic/greetings")
    public Greeting greeting(RoomShareMessage message) throws Exception {

        Thread.sleep(1000);
        return new Greeting("Hello, " + message.getName() + " " + message.getNumber() + "!");
    }


}
package com.ksr.controller;

import com.ksr.messaging.RoomShareMessage;
import com.ksr.model.Room;
import com.ksr.repository.RoomRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Controller
public class RoomController {
    private static final Log logger = LogFactory.getLog(RoomController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private RoomRepository roomRepository;

    @MessageMapping("/rooms.{username}")
    public void getUserRooms(@Payload RoomShareMessage roomShareMessage, @DestinationVariable("username") String username, Principal principal) {
        List<Room> roomsList = roomRepository.findAllByOwner(username);
        simpMessagingTemplate.convertAndSendToUser(username, "/queue/user-reservations", roomsList);
    }
}

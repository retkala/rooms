package com.ksr.controller;

import com.ksr.messaging.RoomShareMessage;
import com.ksr.model.Room;
import com.ksr.model.RoomShare;
import com.ksr.repository.RoomRepository;
import com.ksr.repository.RoomSharesRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Controller
public class RoomSharesController {

    private static final Log logger = LogFactory.getLog(RoomSharesController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private RoomSharesRepository roomSharesRepository;

    @MessageMapping("/roomshares")
    @SendToUser
    public List<RoomShare> findSharedRooms() {
        return roomSharesRepository.findAll();
    }


}

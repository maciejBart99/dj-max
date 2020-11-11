package com.djmax.djmax.rooms.rest.controllers;

import com.djmax.djmax.rooms.data_access.commands.add_item.AddItemCommand;
import com.djmax.djmax.shared.core.services.CommandMediator;
import com.djmax.djmax.shared.core.services.QueryMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms/items")
public class RoomItemsController {
    @Autowired
    private QueryMediator queryMediator;

    @Autowired
    private CommandMediator commandMediator;

    @PostMapping
    public ResponseEntity<String> addRoom(@RequestBody AddItemCommand addRoomCommand) throws Exception {
        commandMediator.<AddItemCommand>dispatch(addRoomCommand);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }
}

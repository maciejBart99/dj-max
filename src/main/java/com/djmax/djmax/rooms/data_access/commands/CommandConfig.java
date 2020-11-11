package com.djmax.djmax.rooms.data_access.commands;

import com.djmax.djmax.rooms.data_access.commands.add_item.AddItemCommand;
import com.djmax.djmax.rooms.data_access.commands.add_item.AddItemHandler;
import com.djmax.djmax.rooms.data_access.commands.add_room.AddRoomCommand;
import com.djmax.djmax.rooms.data_access.commands.add_room.AddRoomHandler;
import com.djmax.djmax.rooms.data_access.commands.edit_room.EditRoomCommand;
import com.djmax.djmax.rooms.data_access.commands.edit_room.EditRoomHandler;
import com.djmax.djmax.rooms.data_access.commands.remove_item.RemoveItemCommand;
import com.djmax.djmax.rooms.data_access.commands.remove_item.RemoveItemHandler;
import com.djmax.djmax.rooms.data_access.commands.remove_room.RemoveRoomCommand;
import com.djmax.djmax.shared.core.services.CommandMediator;
import com.djmax.djmax.rooms.data_access.commands.remove_room.RemoveRoomHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CommandConfig {

    @Autowired
    private CommandMediator mediator;

    @Autowired
    private AddRoomHandler handler;

    @Autowired
    private RemoveRoomHandler removeRoomHandler;

    @Autowired
    private AddItemHandler addItemHandler;

    @Autowired
    private RemoveItemHandler removeItemHandler;

    @Autowired
    private EditRoomHandler editRoomHandler;

    @PostConstruct
    public void initCommands() {
        mediator.addCommandHandler(AddRoomCommand.class, handler);
        mediator.addCommandHandler(RemoveRoomCommand.class, removeRoomHandler);
        mediator.addCommandHandler(AddItemCommand.class, addItemHandler);
        mediator.addCommandHandler(RemoveItemCommand.class, removeItemHandler);
        mediator.addCommandHandler(EditRoomCommand.class, editRoomHandler);
    }
}

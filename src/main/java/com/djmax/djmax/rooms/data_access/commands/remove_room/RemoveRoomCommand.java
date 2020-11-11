package com.djmax.djmax.rooms.data_access.commands.remove_room;

import com.djmax.djmax.shared.core.domain.interfaces.ICommand;

public class RemoveRoomCommand implements ICommand {

   private final long id;

    public RemoveRoomCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

package com.djmax.djmax.rooms.data_access.commands.remove_item;

import com.djmax.djmax.shared.core.domain.interfaces.ICommand;

public class RemoveItemCommand implements ICommand {
    private long id;

    public RemoveItemCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

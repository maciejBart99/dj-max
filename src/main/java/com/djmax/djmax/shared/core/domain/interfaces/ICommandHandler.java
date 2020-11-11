package com.djmax.djmax.shared.core.domain.interfaces;

import com.djmax.djmax.rooms.domain.exceptions.RoomNotFoundException;

public interface ICommandHandler {
    void execute(ICommand command) throws RoomNotFoundException;
}

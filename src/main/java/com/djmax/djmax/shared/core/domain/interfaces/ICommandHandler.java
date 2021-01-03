package com.djmax.djmax.shared.core.domain.interfaces;

import com.djmax.djmax.rooms.domain.exceptions.RoomNotFoundException;

public interface ICommandHandler<T extends ICommand> {
    void execute(T command) throws RoomNotFoundException;
}

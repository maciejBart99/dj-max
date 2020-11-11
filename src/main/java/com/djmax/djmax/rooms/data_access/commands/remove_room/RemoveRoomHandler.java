package com.djmax.djmax.rooms.data_access.commands.remove_room;

import com.djmax.djmax.rooms.infrastructure.repositories.IRoomRepository;
import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveRoomHandler implements ICommandHandler {

    @Autowired
    private IRoomRepository repository;

    @Override
    public void execute(ICommand cmd) {
        RemoveRoomCommand command = (RemoveRoomCommand)cmd;
        repository.deleteById(command.getId());
    }
}

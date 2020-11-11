package com.djmax.djmax.rooms.data_access.commands.add_room;

import com.djmax.djmax.rooms.domain.entity.Room;
import com.djmax.djmax.rooms.infrastructure.repositories.IRoomRepository;
import com.djmax.djmax.rooms.socket.services.SocketDispatcher;
import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.ICommandHandler;
import com.djmax.djmax.rooms.data_access.utils.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRoomHandler implements ICommandHandler {

    @Autowired
    private IRoomRepository repository;

    @Autowired
    private CodeService codeService;


    @Override
    public void execute(ICommand cmd) {
        AddRoomCommand command = (AddRoomCommand)cmd;
        Room room = new Room(command.getName(),
                codeService.generateCode(10),
                command.getCreatorName(),
                command.getDescription(),
                command.getQuestsCanAddSongs(),
                command.getQuestsCanEditSongs(),
                command.getLikesRequiredToPlay());
        repository.save(room);
    }
}

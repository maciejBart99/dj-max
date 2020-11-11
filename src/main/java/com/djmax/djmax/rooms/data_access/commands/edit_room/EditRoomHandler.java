package com.djmax.djmax.rooms.data_access.commands.edit_room;

import com.djmax.djmax.rooms.domain.entity.Room;
import com.djmax.djmax.rooms.domain.exceptions.RoomNotFoundException;
import com.djmax.djmax.rooms.infrastructure.repositories.IRoomRepository;
import com.djmax.djmax.rooms.socket.services.SocketDispatcher;
import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditRoomHandler implements ICommandHandler {

    @Autowired
    private IRoomRepository repository;

    @Autowired
    private SocketDispatcher socketDispatcher;

    @Override
    public void execute(ICommand cmd) throws RoomNotFoundException {
        EditRoomCommand command = (EditRoomCommand)cmd;
        Optional<Room> room = repository.findById(command.getId());
        if (room.isEmpty()) throw new RoomNotFoundException(Long.toString(command.getId()));
        Room roomEntity = room.get();
        roomEntity.setDescription(command.getDescription());
        roomEntity.setLikesRequiredToPlay(command.getLikesRequiredToPlay());
        roomEntity.setQuestsCanAddSongs(command.getQuestsCanAddSongs());
        roomEntity.setQuestsCanEditSongs(command.getQuestsCanEditSongs());
        repository.save(roomEntity);
        socketDispatcher.dispatchRoomEdit(roomEntity);
    }
}

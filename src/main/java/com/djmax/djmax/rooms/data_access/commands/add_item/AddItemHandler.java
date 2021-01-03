package com.djmax.djmax.rooms.data_access.commands.add_item;

import com.djmax.djmax.rooms.domain.entity.QueueItem;
import com.djmax.djmax.rooms.domain.entity.Room;
import com.djmax.djmax.rooms.domain.exceptions.RoomNotFoundException;
import com.djmax.djmax.rooms.infrastructure.repositories.IQueueItemRepository;
import com.djmax.djmax.rooms.infrastructure.repositories.IRoomRepository;
import com.djmax.djmax.rooms.socket.services.SocketDispatcher;
import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddItemHandler implements ICommandHandler<AddItemCommand> {

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IQueueItemRepository queueItemRepository;

    @Autowired
    private SocketDispatcher socketDispatcher;

    @Override
    public void execute(AddItemCommand command) throws RoomNotFoundException {
        Optional<Room> room = roomRepository.findById(command.getRoomId());
        if (room.isEmpty()) throw new RoomNotFoundException(Long.toString(command.getRoomId()));
        QueueItem queueItem = new QueueItem(
                room.get().getQueueItems().size(),
                command.getUrl(),
                command.getName(),
                command.getArtist(),
                command.getAlbum(),
                command.getAlbumImageUrl(),
                command.getUserName(),
                room.get()
        );
        queueItemRepository.save(queueItem);
        socketDispatcher.dispatchItemPost(queueItem);
    }
}

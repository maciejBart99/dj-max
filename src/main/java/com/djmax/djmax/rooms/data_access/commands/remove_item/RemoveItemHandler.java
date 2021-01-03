package com.djmax.djmax.rooms.data_access.commands.remove_item;

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
public class RemoveItemHandler implements ICommandHandler<RemoveItemCommand> {

    @Autowired
    private IQueueItemRepository repository;

    @Autowired
    private SocketDispatcher socketDispatcher;

    @Override
    public void execute(RemoveItemCommand command) throws RoomNotFoundException {
        Optional<QueueItem> item = repository.findById(command.getId());
        if (item.isEmpty()) throw new RoomNotFoundException(Long.toString(command.getId()));
        socketDispatcher.dispatchItemDelete(item.get());
        repository.delete(item.get());
    }
}

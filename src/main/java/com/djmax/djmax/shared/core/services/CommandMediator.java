package com.djmax.djmax.shared.core.services;

import com.djmax.djmax.rooms.domain.exceptions.HandlerNotRegisteredException;
import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.ICommandHandler;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommandMediator {

    private final Map<Class<? extends ICommand>, ICommandHandler<?>> entries = new HashMap<>();

    public void addCommandHandler(Class<? extends ICommand> command, ICommandHandler<?> handler) {
        entries.put(command, handler);
    }

    public <T extends ICommand> void dispatch(T command) throws Exception {
        Optional<ICommandHandler<T>> iCommandHandler = Optional.ofNullable((ICommandHandler<T>) entries.get(command.getClass()));
        if (iCommandHandler.isEmpty()) throw new HandlerNotRegisteredException();
        iCommandHandler.get().execute(command);
    }
}


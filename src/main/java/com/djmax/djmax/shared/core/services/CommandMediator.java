package com.djmax.djmax.shared.core.services;

import com.djmax.djmax.rooms.domain.exceptions.HandlerNotRegisteredException;
import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.ICommandHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandMediator {

    private static class Entry {
        private final Class<?> command;
        private final ICommandHandler handler;

        public Entry(Class<?> command, ICommandHandler handler) {
            this.command = command;
            this.handler = handler;
        }

        public Class<?> getCommand() {
            return command;
        }

        public ICommandHandler getHandler() {
            return handler;
        }
    }

    private final List<Entry> entries = new ArrayList<>();

    public void addCommandHandler(Class<?> command, ICommandHandler handler) {
        entries.add(new Entry(command, handler));
    }

    public <T extends ICommand> void dispatch(T command) throws Exception, HandlerNotRegisteredException {
        Optional<Entry> iCommandHandler = entries.stream()
                .filter(entry -> entry.getCommand() == command.getClass()).findFirst();
        if (iCommandHandler.isEmpty()) throw new HandlerNotRegisteredException();
        iCommandHandler.get().getHandler().execute(command);
    }
}

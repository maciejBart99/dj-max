package com.djmax.djmax.shared.core.services;

import com.djmax.djmax.rooms.domain.exceptions.HandlerNotRegisteredException;
import com.djmax.djmax.shared.core.domain.interfaces.IQuery;
import com.djmax.djmax.shared.core.domain.interfaces.IQueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QueryMediator {

    private static class Entry {
        private final Class<?> command;
        private final IQueryHandler<?> handler;

        public Entry(Class<?> command, IQueryHandler<?> handler) {
            this.command = command;
            this.handler = handler;
        }

        public Class<?> getCommand() {
            return command;
        }

        public IQueryHandler<?> getHandler() {
            return handler;
        }
    }

    private final List<Entry> entries = new ArrayList<>();

    public void addQueryHandler(Class<?> command, IQueryHandler<?> handler) {
        entries.add(new Entry(command, handler));
    }

    public <T extends IQuery, P> Optional<P> dispatch(T command) throws HandlerNotRegisteredException, Exception {
        Optional<Entry> iQueryHandler = entries.stream()
                .filter(entry -> entry.getCommand() == command.getClass()).findFirst();
        if (iQueryHandler.isEmpty()) throw new HandlerNotRegisteredException();
        return (Optional<P>) iQueryHandler.get().getHandler().execute(command);
    }
}

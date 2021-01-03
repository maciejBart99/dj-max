package com.djmax.djmax.shared.core.services;

import com.djmax.djmax.rooms.domain.exceptions.HandlerNotRegisteredException;
import com.djmax.djmax.shared.core.domain.interfaces.IQuery;
import com.djmax.djmax.shared.core.domain.interfaces.IQueryHandler;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryMediator {

    private final Map<Class<? extends IQuery>, IQueryHandler<?, ? extends IQuery>> entries = new HashMap<>();

    public void addQueryHandler(Class<? extends IQuery> command, IQueryHandler<?, ? extends IQuery> handler) {
        entries.put(command, handler);
    }

    public <P, T extends IQuery> P dispatch(T command) throws HandlerNotRegisteredException {
        Optional<IQueryHandler<P, T>> iQueryHandler = Optional.ofNullable((IQueryHandler<P, T>)entries.get(command.getClass()));
        if (iQueryHandler.isEmpty()) throw new HandlerNotRegisteredException();
        return iQueryHandler.get().execute(command);
    }
}

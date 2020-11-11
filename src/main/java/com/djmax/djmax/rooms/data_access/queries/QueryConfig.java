package com.djmax.djmax.rooms.data_access.queries;

import com.djmax.djmax.shared.core.services.QueryMediator;
import com.djmax.djmax.rooms.data_access.queries.get_room.GetRoomHandler;
import com.djmax.djmax.rooms.data_access.queries.get_room.GetRoomQuery;
import com.djmax.djmax.rooms.data_access.queries.get_room_by_code.GetRoomByCodeHandler;
import com.djmax.djmax.rooms.data_access.queries.get_room_by_code.GetRoomByCodeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class QueryConfig {

    @Autowired
    private QueryMediator mediator;

    @Autowired
    private GetRoomByCodeHandler getRoomByCodeHandler;

    @Autowired
    private GetRoomHandler getRoomHandler;

    @PostConstruct
    public void initQueries() {
        mediator.addQueryHandler(GetRoomByCodeQuery.class, getRoomByCodeHandler);
        mediator.addQueryHandler(GetRoomQuery.class, getRoomHandler);
    }
}

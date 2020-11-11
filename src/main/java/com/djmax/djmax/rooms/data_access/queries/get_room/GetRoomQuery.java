package com.djmax.djmax.rooms.data_access.queries.get_room;

import com.djmax.djmax.shared.core.domain.interfaces.IQuery;

public class GetRoomQuery implements IQuery {
    private final long id;

    public GetRoomQuery(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

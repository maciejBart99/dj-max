package com.djmax.djmax.rooms.data_access.queries.get_room_by_code;

import com.djmax.djmax.shared.core.domain.interfaces.IQuery;

public class GetRoomByCodeQuery implements IQuery {
    private final String roomCode;

    public GetRoomByCodeQuery(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }
}

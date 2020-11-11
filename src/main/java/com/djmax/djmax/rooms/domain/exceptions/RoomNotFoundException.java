package com.djmax.djmax.rooms.domain.exceptions;

public class RoomNotFoundException extends Exception {

    public RoomNotFoundException(String room) {
        super("Room not found " + room);
    }
}

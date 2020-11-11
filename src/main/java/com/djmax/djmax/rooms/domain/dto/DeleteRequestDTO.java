package com.djmax.djmax.rooms.domain.dto;

public class DeleteRequestDTO {
    private final long id;


    public DeleteRequestDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

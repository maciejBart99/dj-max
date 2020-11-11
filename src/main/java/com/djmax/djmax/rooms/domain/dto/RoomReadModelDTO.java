package com.djmax.djmax.rooms.domain.dto;

import com.djmax.djmax.rooms.domain.entity.QueueItem;

import java.util.List;

public class RoomReadModelDTO {
    private long id;

    private List<QueueItem> queueItems;

    private String name;

    private String code;

    private String creatorName;

    private String description;

    private Boolean questsCanAddSongs;

    private Boolean questsCanEditSongs;

    private long likesRequiredToPlay;

    public RoomReadModelDTO(long id, List<QueueItem> queueItems, String name, String code, String creatorName, String description, Boolean questsCanAddSongs, Boolean questsCanEditSongs, long likesRequiredToPlay) {
        this.id = id;
        this.queueItems = queueItems;
        this.name = name;
        this.code = code;
        this.creatorName = creatorName;
        this.description = description;
        this.questsCanAddSongs = questsCanAddSongs;
        this.questsCanEditSongs = questsCanEditSongs;
        this.likesRequiredToPlay = likesRequiredToPlay;
    }
}

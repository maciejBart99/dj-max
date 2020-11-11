package com.djmax.djmax.rooms.data_access.commands.add_room;

import com.djmax.djmax.shared.core.domain.interfaces.ICommand;

public class AddRoomCommand implements ICommand {
    private final String creatorName;

    private final String description;

    private final String name;

    private final Boolean questsCanAddSongs;

    private final Boolean questsCanEditSongs;

    private final long likesRequiredToPlay;

    public AddRoomCommand(String creatorName, String description, Boolean questsCanAddSongs, Boolean questsCanEditSongs, long likesRequiredToPlay, String name) {
        this.creatorName = creatorName;
        this.description = description;
        this.questsCanAddSongs = questsCanAddSongs;
        this.questsCanEditSongs = questsCanEditSongs;
        this.name = name;
        this.likesRequiredToPlay = likesRequiredToPlay;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getQuestsCanAddSongs() {
        return questsCanAddSongs;
    }

    public Boolean getQuestsCanEditSongs() {
        return questsCanEditSongs;
    }

    public long getLikesRequiredToPlay() {
        return likesRequiredToPlay;
    }

    public String getName() {
        return name;
    }

}

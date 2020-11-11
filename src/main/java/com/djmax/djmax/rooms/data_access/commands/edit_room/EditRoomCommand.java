package com.djmax.djmax.rooms.data_access.commands.edit_room;

import com.djmax.djmax.shared.core.domain.interfaces.ICommand;

public class EditRoomCommand implements ICommand {
    private final String description;

    private final Boolean questsCanAddSongs;

    private final Boolean questsCanEditSongs;

    private final long likesRequiredToPlay;

    private final long id;

    public EditRoomCommand(String description, Boolean questsCanAddSongs, Boolean questsCanEditSongs, long likesRequiredToPlay, long id) {
        this.description = description;
        this.questsCanAddSongs = questsCanAddSongs;
        this.questsCanEditSongs = questsCanEditSongs;
        this.likesRequiredToPlay = likesRequiredToPlay;
        this.id = id;
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

    public long getId() {
        return id;
    }
}

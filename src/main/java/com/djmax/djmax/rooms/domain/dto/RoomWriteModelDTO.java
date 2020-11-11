package com.djmax.djmax.rooms.domain.dto;

public class RoomWriteModelDTO {
    private String description;

    private Boolean questsCanAddSongs;

    private Boolean questsCanEditSongs;

    private long likesRequiredToPlay;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getQuestsCanAddSongs() {
        return questsCanAddSongs;
    }

    public void setQuestsCanAddSongs(Boolean questsCanAddSongs) {
        this.questsCanAddSongs = questsCanAddSongs;
    }

    public Boolean getQuestsCanEditSongs() {
        return questsCanEditSongs;
    }

    public void setQuestsCanEditSongs(Boolean questsCanEditSongs) {
        this.questsCanEditSongs = questsCanEditSongs;
    }

    public long getLikesRequiredToPlay() {
        return likesRequiredToPlay;
    }

    public void setLikesRequiredToPlay(long likesRequiredToPlay) {
        this.likesRequiredToPlay = likesRequiredToPlay;
    }
}

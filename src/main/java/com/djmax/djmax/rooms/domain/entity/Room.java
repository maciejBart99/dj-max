package com.djmax.djmax.rooms.domain.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
@EntityListeners(AuditingEntityListener.class)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<QueueItem> queueItems;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "description")
    private String description;

    @Column(name = "quests_can_add_songs")
    private Boolean questsCanAddSongs;

    @Column(name = "quests_can_edit_songs")
    private Boolean questsCanEditSongs;

    @Column(name = "likes_required")
    private long likesRequiredToPlay;

    public Room(String name, String code, String creatorName, String description, Boolean questsCanAddSongs, Boolean questsCanEditSongs, long likesRequiredToPlay) {
        this.name = name;
        this.code = code;
        this.creatorName = creatorName;
        this.description = description;
        this.questsCanAddSongs = questsCanAddSongs;
        this.questsCanEditSongs = questsCanEditSongs;
        this.likesRequiredToPlay = likesRequiredToPlay;
    }

    public long getId() {
        return id;
    }

    public List<QueueItem> getQueueItems() {
        return queueItems;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

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

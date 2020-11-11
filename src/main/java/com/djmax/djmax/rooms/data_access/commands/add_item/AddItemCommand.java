package com.djmax.djmax.rooms.data_access.commands.add_item;

import com.djmax.djmax.shared.core.domain.interfaces.ICommand;
import com.djmax.djmax.shared.core.domain.interfaces.IQuery;

import java.util.Date;

public class AddItemCommand implements IQuery, ICommand {
    private long id;

    private long roomId;

    private String url;

    private String name;

    private String artist;

    private String album;

    private String albumImageUrl;

    private String userName;

    private Date posted;

    private long likes;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getAlbumImageUrl() {
        return albumImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public Date getPosted() {
        return posted;
    }

    public long getLikes() {
        return likes;
    }

    public long getId() {
        return id;
    }

    public long getRoomId() {
        return roomId;
    }
}

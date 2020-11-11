package com.djmax.djmax.rooms.domain.dto;


import java.util.Date;

public class RoomItemReadModelDTO {
    private long id;

    private long queueOrderToken;

    private String url;

    private String name;

    private String artist;

    private String album;

    private String albumImageUrl;

    private String userName;

    private Date posted;

    private long likes;

    public RoomItemReadModelDTO(long id, long queueOrderToken, String url, String name, String artist, String album, String albumImageUrl, String userName, Date posted, long likes) {
        this.id = id;
        this.queueOrderToken = queueOrderToken;
        this.url = url;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.albumImageUrl = albumImageUrl;
        this.userName = userName;
        this.posted = posted;
        this.likes = likes;
    }
}

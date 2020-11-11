package com.djmax.djmax.rooms.domain.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
@EntityListeners(AuditingEntityListener.class)
public class QueueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room", referencedColumnName = "id")
    private Room room;

    @Column(name = "queue_order_token")
    private long queueOrderToken;

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album")
    private String album;

    @Column(name = "albumImageUrl")
    private String albumImageUrl;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "posted")
    private Date posted;

    @Column(name = "likes")
    private long likes;

    public QueueItem(long queueOrderToken, String url, String name, String artist, String album, String albumImageUrl, String userName, Room room) {
        this.queueOrderToken = queueOrderToken;
        this.url = url;
        this.name = name;
        this.room = room;
        this.artist = artist;
        this.album = album;
        this.albumImageUrl = albumImageUrl;
        this.userName = userName;
        this.posted = new Date();
        this.likes = 0;
    }

    public long getQueueOrderToken() {
        return queueOrderToken;
    }

    public void setQueueOrderToken(long queueOrderToken) {
        this.queueOrderToken = queueOrderToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumImageUrl() {
        return albumImageUrl;
    }

    public void setAlbumImageUrl(String albumImageUrl) {
        this.albumImageUrl = albumImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }
}

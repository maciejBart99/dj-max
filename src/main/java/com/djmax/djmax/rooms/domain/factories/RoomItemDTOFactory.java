package com.djmax.djmax.rooms.domain.factories;

import com.djmax.djmax.rooms.domain.dto.RoomItemReadModelDTO;
import com.djmax.djmax.rooms.domain.entity.QueueItem;
import org.springframework.stereotype.Service;

@Service
public class RoomItemDTOFactory {
    public RoomItemReadModelDTO produceDTO(QueueItem entity) {
        return new RoomItemReadModelDTO(
                entity.getId(),
                entity.getQueueOrderToken(),
                entity.getUrl(),
                entity.getName(),
                entity.getArtist(),
                entity.getAlbum(),
                entity.getAlbumImageUrl(),
                entity.getUserName(),
                entity.getPosted(),
                entity.getLikes()
        );
    }
}

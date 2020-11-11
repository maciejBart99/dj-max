package com.djmax.djmax.rooms.domain.factories;

import com.djmax.djmax.rooms.domain.dto.RoomReadModelDTO;
import com.djmax.djmax.rooms.domain.entity.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomDTOFactory {

    public RoomReadModelDTO produceDTO(Room entity) {
        return new RoomReadModelDTO(
                entity.getId(),
                entity.getQueueItems(),
                entity.getName(),
                entity.getCode(),
                entity.getCreatorName(),
                entity.getDescription(),
                entity.getQuestsCanAddSongs(),
                entity.getQuestsCanEditSongs(),
                entity.getLikesRequiredToPlay()
        );
    }
}

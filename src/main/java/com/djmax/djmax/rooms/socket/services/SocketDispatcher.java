package com.djmax.djmax.rooms.socket.services;

import com.djmax.djmax.rooms.domain.dto.DeleteRequestDTO;
import com.djmax.djmax.rooms.domain.dto.RoomItemReadModelDTO;
import com.djmax.djmax.rooms.domain.dto.RoomReadModelDTO;
import com.djmax.djmax.rooms.domain.dto.RoomWriteModelDTO;
import com.djmax.djmax.rooms.domain.entity.QueueItem;
import com.djmax.djmax.rooms.domain.entity.Room;
import com.djmax.djmax.rooms.domain.factories.RoomDTOFactory;
import com.djmax.djmax.rooms.domain.factories.RoomItemDTOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SocketDispatcher {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private RoomItemDTOFactory roomItemDTOFactory;

    @Autowired
    private RoomDTOFactory roomDTOFactory;

    public void dispatchItemPost(QueueItem queueItem) {
        String url = "/room/" + queueItem.getRoom().getId() + "/items/add";
        RoomItemReadModelDTO roomItemReadModelDTO = roomItemDTOFactory.produceDTO(queueItem);
        template.convertAndSend(url, roomItemReadModelDTO);
    }

    public void dispatchItemPut(QueueItem queueItem) {
        String url = "/room/" + queueItem.getRoom().getId() + "/items/edit";
        RoomItemReadModelDTO roomItemReadModelDTO = roomItemDTOFactory.produceDTO(queueItem);
        template.convertAndSend(url, roomItemReadModelDTO);
    }

    public void dispatchItemDelete(QueueItem queueItem) {
        String url = "/room/" + queueItem.getRoom().getId() + "/items/remove";
        template.convertAndSend(url, new DeleteRequestDTO(queueItem.getId()));
    }

    public void dispatchRoomEdit(Room room) {
        String url = "/room/" + room.getId() + "/edit";
        RoomReadModelDTO roomItemReadModelDTO = roomDTOFactory.produceDTO(room);
        template.convertAndSend(url, roomItemReadModelDTO);
    }
}

package com.djmax.djmax.rooms.data_access.queries.get_room_by_code;

import com.djmax.djmax.rooms.domain.dto.RoomReadModelDTO;
import com.djmax.djmax.rooms.domain.factories.RoomDTOFactory;
import com.djmax.djmax.rooms.infrastructure.repositories.IRoomRepository;
import com.djmax.djmax.shared.core.domain.interfaces.IQuery;
import com.djmax.djmax.shared.core.domain.interfaces.IQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetRoomByCodeHandler implements IQueryHandler<Optional<RoomReadModelDTO>> {

    @Autowired
    private IRoomRepository repository;

    @Autowired
    private RoomDTOFactory factory;

    public Optional<RoomReadModelDTO> execute(IQuery query) {
        return repository.getByCode(((GetRoomByCodeQuery)query).getRoomCode()).map((room) -> factory.produceDTO(room));
    }
}

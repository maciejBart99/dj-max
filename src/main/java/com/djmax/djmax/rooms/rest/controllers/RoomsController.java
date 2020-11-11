package com.djmax.djmax.rooms.rest.controllers;

import com.djmax.djmax.rooms.domain.dto.RoomReadModelDTO;
import com.djmax.djmax.rooms.domain.dto.RoomWriteModelDTO;
import com.djmax.djmax.rooms.data_access.commands.edit_room.EditRoomCommand;
import com.djmax.djmax.rooms.data_access.commands.remove_room.RemoveRoomCommand;
import com.djmax.djmax.rooms.data_access.commands.add_room.AddRoomCommand;
import com.djmax.djmax.shared.core.services.CommandMediator;
import com.djmax.djmax.shared.core.services.QueryMediator;
import com.djmax.djmax.rooms.data_access.queries.get_room.GetRoomQuery;
import com.djmax.djmax.rooms.data_access.queries.get_room_by_code.GetRoomByCodeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomsController {

    @Autowired
    private QueryMediator queryMediator;

    @Autowired
    private CommandMediator commandMediator;

    @PostMapping
    public ResponseEntity<String> addRoom(@RequestBody AddRoomCommand addRoomCommand) throws Exception {
        commandMediator.dispatch(addRoomCommand);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeRoom(@PathVariable() long id) throws Exception {
        commandMediator.dispatch(new RemoveRoomCommand(id));
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> removeRoom(@PathVariable() long id, @RequestBody RoomWriteModelDTO roomWriteModelDTO) throws Exception {
        commandMediator.dispatch(new EditRoomCommand(
                roomWriteModelDTO.getDescription(),
                roomWriteModelDTO.getQuestsCanAddSongs(),
                roomWriteModelDTO.getQuestsCanEditSongs(),
                roomWriteModelDTO.getLikesRequiredToPlay(),
                id
        ));
        return new ResponseEntity<String>("Updated", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<RoomReadModelDTO>> getRoom(@PathVariable() long id) throws Exception {
        return new ResponseEntity<Optional<RoomReadModelDTO>>(queryMediator.<GetRoomQuery, RoomReadModelDTO>dispatch(new GetRoomQuery(id)), HttpStatus.OK);
    }

    @GetMapping("code/{code}")
    public ResponseEntity<Optional<RoomReadModelDTO>> getRoom(@PathVariable() String code) throws Exception {
        return new ResponseEntity<Optional<RoomReadModelDTO>>(queryMediator.<GetRoomByCodeQuery, RoomReadModelDTO>dispatch(new GetRoomByCodeQuery(code)), HttpStatus.OK);
    }
}

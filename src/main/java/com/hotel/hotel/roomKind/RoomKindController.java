package com.hotel.hotel.roomKind;

import com.hotel.hotel.gallery.GalleryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomKindController {

    private RoomKindRepository roomKindRepository;

    public RoomKindController(RoomKindRepository roomKindRepository) {
        this.roomKindRepository = roomKindRepository;
    }

    @GetMapping("/room-kind")
    public ResponseEntity<?> getAllRoomKind()
    {
        return new ResponseEntity(roomKindRepository.findAll(), HttpStatus.OK);

    }
}

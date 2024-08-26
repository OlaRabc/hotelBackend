package com.hotel.hotel.getReservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetReservationController {

    RoomKindToReservationRepository roomKindToReservationRepository;
    ReservationRepository reservationRepository;

    public GetReservationController(RoomKindToReservationRepository roomKindToReservationRepository, ReservationRepository reservationRepository) {
        this.roomKindToReservationRepository = roomKindToReservationRepository;
        this.reservationRepository = reservationRepository;
    }

    private List<RoomDAO> makeDAORoomList(List<RoomKindToReservationEntity> roomKindEntities) {
        List<RoomDAO> list = new ArrayList<>();

        for (RoomKindToReservationEntity room : roomKindEntities) {
            list.add(new RoomDAO(room));
        }

        return list;
    }

    private void setAvailabilityOfRooms(List<RoomDAO> roomDAOS, List<ReservationEntity> reservationEntities) {

        for (ReservationEntity reservation : reservationEntities) {

            for (RoomDAO roomDAO : roomDAOS) {
                if (roomDAO.getRoomKindId() == reservation.getReservationId())
                    roomDAO.setFreeRooms(roomDAO.getFreeRooms() - 1);
            }
        }
    }


    @GetMapping("/reservation/{arrivalDate}/{departureDate}")
    public ResponseEntity<?> getAllRoomKind(@PathVariable Date arrivalDate, @PathVariable Date departureDate) {

        List<RoomKindToReservationEntity> roomKindEntities = roomKindToReservationRepository.findAll();

        List<RoomDAO> roomDAOS = makeDAORoomList(roomKindEntities);

        List<ReservationEntity> reservationEntities = reservationRepository.findByArrivalDateBetweenAndDepartureDateBetween(arrivalDate, departureDate,arrivalDate, departureDate);

        if (reservationEntities.size() > 1) {
            setAvailabilityOfRooms(roomDAOS, reservationEntities);
        }
        return new ResponseEntity(roomDAOS, HttpStatus.OK);

    }
}
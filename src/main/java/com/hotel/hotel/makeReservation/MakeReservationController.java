package com.hotel.hotel.makeReservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MakeReservationController {
    private MakeReservationRepository makeReservationRepository;
    private ReservedRoomsRepository reservedRoomsRepository;

    public MakeReservationController(MakeReservationRepository makeReservationRepository, ReservedRoomsRepository reservedRoomsRepository) {
        this.makeReservationRepository = makeReservationRepository;
        this.reservedRoomsRepository = reservedRoomsRepository;
    }

//    public void makeReservation(MakeReservationDAO reservation) {
//        Optional<ClientEntity> client = clientRepository.findById(reservation.getPersonalId());
//        if (!client.isPresent()) {
//            ClientEntity newClient = new ClientEntity(
//                    reservation.getPersonalId(),
//                    reservation.getFirstName(),
//                    reservation.getLastName(),
//                    reservation.getMail(),
//                    reservation.getPhone());
//
//            clientRepository.save(newClient);
//        }
//
//        makeReservationRepository.saveAndFlush(
//                new MakeReservationEntity(
//                        null,
//                        reservation.getRoomKindId(),
//                        reservation.getArrivalDate(),
//                        reservation.getDepartureDate(),
//                        reservation.getPersonalId()));
//
//    }

    @PostMapping("/make-reservation")
    @ResponseBody
    public ResponseEntity<?> postCompanyComment(@RequestBody MakeReservationDAO reservationDAO) {

         MakeReservationEntity reservationEntity = new MakeReservationEntity(
                null,
                reservationDAO.getArrivalDate(),
                reservationDAO.getDepartureDate(),
                reservationDAO.getName(),
                reservationDAO.getMail(),
                reservationDAO.getVatInvoice(),
                reservationDAO.getReservationDetails(),
                reservationDAO.getAgreePromotions(),
                reservationDAO.getPaymentMethod(),
                "",
                 false,
                 false,
                 false,
                 false,
                 false
                 );

        for (RoomDAO room : reservationDAO.getRoomList()
        ) {
            for (int i = 0; i < room.getRoomCount(); i++) {
                ReservedRoomsEntity reserved = reservedRoomsRepository.saveAndFlush(
                        new ReservedRoomsEntity(
                                null,
                                room.getId(),
                                reservationDAO.getArrivalDate(),
                                reservationDAO.getDepartureDate()
                        ));

                reservationEntity.setRooms(reservationEntity.getRooms()+" "+ reserved.getRoomKindId());
            }
        }

        if(reservationDAO.getServiceList().contains("FLOWERS")) reservationEntity.setIsFlowers(true);
        if(reservationDAO.getServiceList().contains("PROSECCO")) reservationEntity.setIsProsecco(true);
        if(reservationDAO.getServiceList().contains("UNDERGROUND")) reservationEntity.setIsUndergroundParking(true);
        if(reservationDAO.getServiceList().contains("PARKING")) reservationEntity.setIsParking(true);
        if(reservationDAO.getServiceList().contains("BABY")) reservationEntity.setIsBabyBed(true);


        makeReservationRepository.saveAndFlush(reservationEntity);
        return new ResponseEntity(HttpStatus.OK, HttpStatus.OK);
    }
}

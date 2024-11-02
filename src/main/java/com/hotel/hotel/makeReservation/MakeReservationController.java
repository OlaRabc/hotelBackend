package com.hotel.hotel.makeReservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MakeReservationController {
    private MakeReservationRepository makeReservationRepository;

    public MakeReservationController(MakeReservationRepository makeReservationRepository) {
        this.makeReservationRepository = makeReservationRepository;
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
    public ResponseEntity<?> postCompanyComment(@RequestBody List<MakeReservationDAO> makeReservationDAO) {
        System.out.println(makeReservationDAO.toString());

        for (MakeReservationDAO reservationDAO : makeReservationDAO
        ) {
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
                    "room");

            for (RoomDAO room : reservationDAO.getRoomList()
            ) {

                    ReservationRoomsEntity roomEntity = new ReservationRoomsEntity(
                            null,
                            room.getId(),
                            reservationDAO.getArrivalDate(),
                            reservationDAO.getDepartureDate());

                for (int i = 0; i < room.getRoomCount(); i++) { //zapisanie tego
                    System.out.println("@@@");
                    System.out.println(roomEntity);
                }
            }

        }
//        for (MakeReservationDAO reservation : makeReservationDAO) {
//            makeReservation(reservation);
//        }

        return new ResponseEntity("ok", HttpStatus.OK);
    }

}

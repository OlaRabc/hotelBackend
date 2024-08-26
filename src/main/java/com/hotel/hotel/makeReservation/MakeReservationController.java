package com.hotel.hotel.makeReservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MakeReservationController {
    private ClientRepository clientRepository;
    private MakeReservationRepository makeReservationRepository;

    public MakeReservationController(ClientRepository clientRepository, MakeReservationRepository makeReservationRepository) {
        this.clientRepository = clientRepository;
        this.makeReservationRepository = makeReservationRepository;
    }

    public void makeReservation(MakeReservationDAO reservation) {
        Optional<ClientEntity> client = clientRepository.findById(reservation.getPersonalId());
        if (!client.isPresent()) {
            ClientEntity newClient = new ClientEntity(
                    reservation.getPersonalId(),
                    reservation.getFirstName(),
                    reservation.getLastName(),
                    reservation.getMail(),
                    reservation.getPhone());

            clientRepository.save(newClient);
        }

        makeReservationRepository.saveAndFlush(
                new MakeReservationEntity(
                        null,
                        reservation.getRoomKindId(),
                        reservation.getArrivalDate(),
                        reservation.getDepartureDate(),
                        reservation.getPersonalId()));

    }

    @PostMapping("/make-reservation")
    @ResponseBody
    public ResponseEntity<?> postCompanyComment(@RequestBody List<MakeReservationDAO> makeReservationDAO) {
        for (MakeReservationDAO reservation : makeReservationDAO) {
            makeReservation(reservation);
        }

        return new ResponseEntity(makeReservationDAO, HttpStatus.OK);
    }

}

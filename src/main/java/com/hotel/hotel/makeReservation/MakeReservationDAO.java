package com.hotel.hotel.makeReservation;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MakeReservationDAO {
    private String name;
    private String mail;
    private Date arrivalDate;
    private Date departureDate;
    private Boolean vatInvoice;

    private String reservationDetails;

    private Boolean agreePromotions;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private List<String> serviceList;
    private List<RoomDAO> roomList;

}

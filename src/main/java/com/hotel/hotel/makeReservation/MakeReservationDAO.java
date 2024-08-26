package com.hotel.hotel.makeReservation;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MakeReservationDAO {
    private Long personalId;
    private String firstName;
    private String lastName;
    private String mail;
    private String phone;

    private Integer roomKindId;
    private Date arrivalDate;
    private Date departureDate;
}

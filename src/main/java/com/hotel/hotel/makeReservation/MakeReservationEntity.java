package com.hotel.hotel.makeReservation;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reservation")
public class MakeReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    private Date arrivalDate;

    private Date departureDate;

    private String name;

    private String email;

    private Boolean vatInvoice;

    private String reservationDetails;

    private Boolean agreePromotions;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String rooms;
    private Boolean isFlowers;
    private Boolean isProsecco;
    private Boolean isUndergroundParking;
    private Boolean isParking;
    private Boolean isBabyBed;
}

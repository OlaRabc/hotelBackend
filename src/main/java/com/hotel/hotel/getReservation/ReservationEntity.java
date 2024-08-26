package com.hotel.hotel.getReservation;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;


    private Integer roomKindId;
    private Date arrivalDate;
    @NonNull
    private Date departureDate;
}

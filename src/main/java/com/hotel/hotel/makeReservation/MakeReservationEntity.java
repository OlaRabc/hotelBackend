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
    private Long reservationId;

    @NonNull
    private Integer roomKindId;
    @NonNull
    private Date arrivalDate;
    @NonNull
    private Date departureDate;

    @NonNull
    private Long  personalId;
}

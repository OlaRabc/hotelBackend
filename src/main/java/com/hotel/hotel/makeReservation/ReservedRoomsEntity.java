package com.hotel.hotel.makeReservation;

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
@Table(name = "reserved_rooms")
public class ReservedRoomsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;


    private Long roomKindId;
    @NonNull
    private Date arrivalDate;
    @NonNull
    private Date departureDate;
}

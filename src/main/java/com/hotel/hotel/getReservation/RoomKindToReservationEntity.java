package com.hotel.hotel.getReservation;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "room_kind")
public class RoomKindToReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomKindId;

    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private int price;

    @NonNull
    private int priceBefore;
    @NonNull
    private int amount;
    @NonNull
    private int maxGuests;
    private String amenities;

    private String img;

}
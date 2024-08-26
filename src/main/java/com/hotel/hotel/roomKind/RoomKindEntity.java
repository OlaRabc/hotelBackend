package com.hotel.hotel.roomKind;

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
public class RoomKindEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomKindId;

    @NonNull
    private String description;
    @NonNull
    private int price;
    @NonNull
    private int amount;
    @NonNull
    private int maxGuests;
    private String amenities;

    private String img;

}
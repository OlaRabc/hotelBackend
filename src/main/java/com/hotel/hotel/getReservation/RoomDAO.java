package com.hotel.hotel.getReservation;


import com.hotel.hotel.roomKind.RoomKindEntity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDAO {
    private Long roomKindId;

    private String description;
    private int price;
    private int freeRooms;
    private int maxGuests;
    private String amenities;

    private String img;

    public RoomDAO(RoomKindToReservationEntity roomKind) {
        this.roomKindId = roomKind.getRoomKindId();
        this.description = roomKind.getDescription();
        this.price = roomKind  .getPrice();
        this.freeRooms = roomKind.getAmount();
        this.maxGuests = roomKind.getMaxGuests();
        this.amenities = roomKind.getAmenities();
        this.img = roomKind.getImg();
    }
}

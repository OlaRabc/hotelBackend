package com.hotel.hotel.getReservation;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDAO {
    private Long id;

    private String title;
    private String description;
    private int price;
    private int priceBefore;
    private int freeRooms;
    private int maxGuests;
    private String amenities;

    private String img;

    public RoomDAO(RoomKindToReservationEntity roomKind) {
        this.id = roomKind.getRoomKindId();
        this.title = roomKind.getTitle();
        this.description = roomKind.getDescription();
        this.price = roomKind.getPrice();
        this.priceBefore = roomKind.getPriceBefore();
        this.freeRooms = roomKind.getAmount();
        this.maxGuests = roomKind.getMaxGuests();
        this.amenities = roomKind.getAmenities();
        this.img = roomKind.getImg();
    }
}

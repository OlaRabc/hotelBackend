package com.hotel.hotel.makeReservation;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDAO {
    private Long id;
    private int roomCount;
}

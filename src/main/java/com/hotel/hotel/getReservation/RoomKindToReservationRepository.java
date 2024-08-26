package com.hotel.hotel.getReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoomKindToReservationRepository")
public interface RoomKindToReservationRepository extends JpaRepository<RoomKindToReservationEntity, Long> {
}

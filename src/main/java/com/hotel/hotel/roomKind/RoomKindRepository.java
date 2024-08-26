package com.hotel.hotel.roomKind;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoomKindRepository")
public interface RoomKindRepository extends JpaRepository<RoomKindEntity, Long> {
}

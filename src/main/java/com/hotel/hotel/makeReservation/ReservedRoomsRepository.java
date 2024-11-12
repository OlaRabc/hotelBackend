package com.hotel.hotel.makeReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ReservedRoomsRepository")
public interface ReservedRoomsRepository extends JpaRepository<ReservedRoomsEntity,Long>{

}

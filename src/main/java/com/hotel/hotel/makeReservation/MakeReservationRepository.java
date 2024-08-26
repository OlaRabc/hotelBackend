package com.hotel.hotel.makeReservation;

import com.hotel.hotel.getReservation.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("MakeReservationRepository")
public interface MakeReservationRepository extends JpaRepository<MakeReservationEntity,Long>{

}

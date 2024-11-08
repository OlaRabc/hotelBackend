package com.hotel.hotel.getReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("ReservationRepository")
public interface ReservationRepository extends JpaRepository<ReservationEntity,Long>{

    public List<ReservationEntity> findByArrivalDateBetweenOrDepartureDateBetween(Date arrivalDateStart, Date arrivalDateEnd,Date departureDateStart, Date departureDateEnd);

    public List<ReservationEntity> findByDepartureDateGreaterThanAndArrivalDateLessThan(Date Start, Date End);
}

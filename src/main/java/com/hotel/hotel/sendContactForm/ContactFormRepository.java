package com.hotel.hotel.sendContactForm;

import com.hotel.hotel.roomKind.RoomKindEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ContactFormRepository")
public interface ContactFormRepository extends JpaRepository<ContactFormEntity, Long> {
}

package com.hotel.hotel.gallery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("GalleryRepository")
public interface GalleryRepository extends JpaRepository<GalleryEntity,Long> {
    List<GalleryEntity>  findAll();
}

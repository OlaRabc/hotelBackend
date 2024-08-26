package com.hotel.hotel.gallery;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Getter
@Setter
public class GalleryController {
    private GalleryRepository galleryRepository;


    public GalleryController(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @GetMapping("/gallery")
    public ResponseEntity<?> getGallery() {
        List<GalleryEntity> gallery = galleryRepository.findAll();
        return new ResponseEntity(gallery, HttpStatus.OK);
    }

}

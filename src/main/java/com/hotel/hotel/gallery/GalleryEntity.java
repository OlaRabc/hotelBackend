package com.hotel.hotel.gallery;


import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "gallery")
public class GalleryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long galleryId;

    @NonNull
    private String img;

}

package com.hotel.hotel.sendContactForm;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "contact_form")
public class ContactFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @NonNull
    private String name;

    @NonNull
    private String phone;

    private String message;
}
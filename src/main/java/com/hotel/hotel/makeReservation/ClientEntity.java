package com.hotel.hotel.makeReservation;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    private Long personalId;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String mail;

    @NonNull
    private String phone;

}

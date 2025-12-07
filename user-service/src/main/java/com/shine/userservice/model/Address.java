package com.shine.userservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private Double lat;
    private Double lng;

}

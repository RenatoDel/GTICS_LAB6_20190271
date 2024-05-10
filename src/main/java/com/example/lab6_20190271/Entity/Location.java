package com.example.lab6_20190271.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false)
    private Integer locationid;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private String country;
}

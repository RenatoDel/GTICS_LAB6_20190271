package com.example.lab6_20190271.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID", nullable = false)
    private Integer siteid;

    @Column(name = "SiteName")
    private String sitename;

    @Column(name = "InstallationDate")
    private String installationdate;

    @Column(name = "Latitude")
    private String latitud;

    @Column(name = "Logintude")
    private String longitud;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location location;
}

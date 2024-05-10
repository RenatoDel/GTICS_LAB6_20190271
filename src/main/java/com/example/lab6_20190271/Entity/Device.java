package com.example.lab6_20190271.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID", nullable = false)
    private Integer deviceid;

    @Column(name = "DeviceName")
    private String devicename;

    @Column(name = "DeviceType")
    private String devicetype;

    @Column(name = "Model")
    private String model;

    @Column(name = "SerialNumber")
    private String snumber;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site site;
}

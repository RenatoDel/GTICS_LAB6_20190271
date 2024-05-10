package com.example.lab6_20190271.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "Technician")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private Integer id;

    @Column(name = "Firstname",length = 50)
    private String firstname;

    @Column(name = "Lastname",length = 100)
    private String lastname;

    @Column(name = "Dni",length = 8)
    private String dni;

    @Column(name = "Phone",length = 9)
    private String phone;

    @Column(name = "Age",length = 50)
    private Integer age;
}

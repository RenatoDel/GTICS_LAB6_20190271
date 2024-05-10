package com.example.lab6_20190271.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false)
    private Integer idticket;

    @Column(name = "Status",length = 50)
    private String status;

    @Column(name = "OpenedDate")
    private String opendate;

    @Column(name = "ClosedDate")

    private String closedDate;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician technician;

}

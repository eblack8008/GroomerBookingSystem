package com.euanblack.GroomerBookingSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookingservice")
public class BookingService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;
}

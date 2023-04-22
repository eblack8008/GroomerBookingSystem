package com.euanblack.GroomerBookingSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "custId")
    @JsonIgnore
    private Customer customer;

    @Column(name = "notes")
    private String notes;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToMany(mappedBy = "booking")
    @JsonIgnoreProperties("booking")
    private List<BookingService> bookingServices = new ArrayList<>();

    public Booking() {
    }

    public Booking(String notes, LocalDateTime date) {
        this.notes = notes;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<BookingService> getBookingServices() {
        return bookingServices;
    }

    public void setBookingServices(List<BookingService> bookingServices) {
        this.bookingServices = bookingServices;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customer=" + customer +
                ", notes='" + notes + '\'' +
                ", bookingServices=" + bookingServices +
                '}';
    }

}

package com.euanblack.GroomerBookingSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceId;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "service")
    @JsonIgnoreProperties("service")
    private List<BookingService> bookingServices = new ArrayList<>();

    public Service() {
    }

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<BookingService> getBookingServices() {
        return bookingServices;
    }

    public void setBookingServices(List<BookingService> bookingServices) {
        this.bookingServices = bookingServices;
    }


    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", bookingServices=" + bookingServices +
                '}';
    }
}

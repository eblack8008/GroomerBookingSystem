package com.euanblack.GroomerBookingSystem.Controller;

import com.euanblack.GroomerBookingSystem.Entity.Booking;
import com.euanblack.GroomerBookingSystem.Entity.Customer;
import com.euanblack.GroomerBookingSystem.Repository.BookingRepository;
import com.euanblack.GroomerBookingSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;

@Controller
@RequestMapping(path = "/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewBooking (@RequestParam String notes,
                                               @RequestParam int custId) {

        Booking booking = new Booking(notes);
        Customer customer = customerRepository.findById(custId).orElseThrow();
        booking.setCustomer(customer);
        bookingRepository.save(booking);
        return "Saved";
    }

}

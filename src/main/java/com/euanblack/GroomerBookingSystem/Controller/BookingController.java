package com.euanblack.GroomerBookingSystem.Controller;

import com.euanblack.GroomerBookingSystem.Entity.Booking;
import com.euanblack.GroomerBookingSystem.Entity.Customer;
import com.euanblack.GroomerBookingSystem.Repository.BookingRepository;
import com.euanblack.GroomerBookingSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="/all") // Map ONLY POST Requests
    public @ResponseBody String addNewBooking (@RequestParam String notes,
                                               @RequestParam int custId,
                                               @RequestParam LocalDateTime date) {

        Booking booking = new Booking(notes, date);
        Customer customer = customerRepository.findById(custId).orElseThrow();
        booking.setCustomer(customer);
        bookingRepository.save(booking);
        return "Saved";
    }

}

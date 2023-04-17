package com.euanblack.GroomerBookingSystem.Controller;

import com.euanblack.GroomerBookingSystem.Entity.Booking;
import com.euanblack.GroomerBookingSystem.Entity.BookingService;
import com.euanblack.GroomerBookingSystem.Entity.Service;
import com.euanblack.GroomerBookingSystem.Repository.BookingRepository;
import com.euanblack.GroomerBookingSystem.Repository.BookingServiceRepository;
import com.euanblack.GroomerBookingSystem.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;

@Controller
@RequestMapping (path = "/bookingService")
public class BookingServiceController {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    BookingServiceRepository bookingServiceRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewBookingService (@RequestParam int bookingId,
                                                      @RequestParam int serviceId) {

        BookingService bookingService = new BookingService();
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        bookingService.setBooking(booking);
        Service service = serviceRepository.findById(serviceId).orElse(null);
        bookingService.setService(service);
        bookingServiceRepository.save(bookingService);
        return "Saved";
    }

}

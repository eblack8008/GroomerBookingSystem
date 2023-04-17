package com.euanblack.GroomerBookingSystem.Repository;

import com.euanblack.GroomerBookingSystem.Entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

}

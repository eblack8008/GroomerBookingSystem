package com.euanblack.GroomerBookingSystem.Repository;

import com.euanblack.GroomerBookingSystem.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}

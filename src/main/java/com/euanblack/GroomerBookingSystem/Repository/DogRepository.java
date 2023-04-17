package com.euanblack.GroomerBookingSystem.Repository;

import com.euanblack.GroomerBookingSystem.Entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Integer> {
}

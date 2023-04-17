package com.euanblack.GroomerBookingSystem.Controller;

import com.euanblack.GroomerBookingSystem.Entity.Customer;
import com.euanblack.GroomerBookingSystem.Entity.Dog;
import com.euanblack.GroomerBookingSystem.Repository.CustomerRepository;
import com.euanblack.GroomerBookingSystem.Repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller // This means that this class is a Controller
@RequestMapping(path="/dog") // This means URL's start with /dog (after Application path)
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewDog (@RequestParam String breed,
                                               @RequestParam String size,
                                               @RequestParam int age,
                                               @RequestParam int ownerId) {

        Dog dog = new Dog(breed, size, age);
        Customer customer = customerRepository.findById(ownerId).orElseThrow();
        dog.setCustomer(customer);
        dogRepository.save(dog);
        return "Saved";
    }
}

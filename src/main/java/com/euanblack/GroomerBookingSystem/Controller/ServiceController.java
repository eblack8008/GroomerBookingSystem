package com.euanblack.GroomerBookingSystem.Controller;

import com.euanblack.GroomerBookingSystem.Entity.Customer;
import com.euanblack.GroomerBookingSystem.Entity.Dog;
import com.euanblack.GroomerBookingSystem.Entity.Service;
import com.euanblack.GroomerBookingSystem.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewService (@RequestParam String serviceName,
                                               @RequestParam double price
                                               ) {

        Service service = new Service(serviceName, price);
        serviceRepository.save(service);
        return "Saved";
    }
}

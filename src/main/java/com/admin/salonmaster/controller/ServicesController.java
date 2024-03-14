package com.admin.salonmaster.controller;


import com.admin.salonmaster.dto.ServicesDTO;
import com.admin.salonmaster.service.ServicesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesList services;

    @PostMapping("/add")
    ResponseEntity<Object> addService(@RequestBody ServicesDTO servicesDTO){
        return services.addService(servicesDTO);
    }

    @PutMapping("/update")
    ResponseEntity<Object> updateService(@RequestBody ServicesDTO servicesDTO){
        return services.updateService(servicesDTO);
    }

    @PatchMapping("/updateStatus/{serviceId}")
    ResponseEntity<Object> updateServiceStatus(@PathVariable Long serviceId,@RequestParam Boolean status){
        return services.updateServiceStatus(serviceId,status);
    }

    @GetMapping("/getById/{serviceId}")
    ResponseEntity<Object> getServiceById(@PathVariable Long serviceId){
        return services.getServiceById(serviceId);
    }
}

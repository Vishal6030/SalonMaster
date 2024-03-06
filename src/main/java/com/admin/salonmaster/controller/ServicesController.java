package com.admin.salonmaster.controller;


import com.admin.salonmaster.entity.Services;
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
    ResponseEntity<Object> addService(Services service){
        return services.addService(service);
    }

    @PutMapping("/update")
    ResponseEntity<Object> updateService(Services service){
        return services.updateService(service);
    }

    @PatchMapping("/updateStatus/{serviceId}")
    ResponseEntity<Object> updateServiceStatus(@PathVariable Long serviceId){
        return services.updateServiceStatus(serviceId);
    }

    @GetMapping("/getById/{serviceId}")
    ResponseEntity<Object> getServiceById(@PathVariable Long serviceId){
        return services.getServiceById(serviceId);
    }
}

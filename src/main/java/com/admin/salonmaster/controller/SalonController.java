package com.admin.salonmaster.controller;

import com.admin.salonmaster.dto.SalonDTO;
import com.admin.salonmaster.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @PostMapping("/addSalon")
    public ResponseEntity<Object> addSalon(@RequestBody SalonDTO salonDTO){
        return salonService.addSalon(salonDTO);
    }

    @PutMapping("/updateSalon")
    public ResponseEntity<Object> updateSalon(@RequestBody SalonDTO salonDTO){
        return salonService.updateSalon(salonDTO);
    }

    @GetMapping("/viewSalonList")
    public ResponseEntity<Object> viewSalonList(){
        return salonService.viewSalonList();
    }

    @GetMapping("/getSalonDataById/{salonId}")
    public ResponseEntity<Object> getSalonDataById(@PathVariable Long salonId){
        return salonService.getSalonDataById(salonId);
    }
}

package com.admin.salonmaster.controller;

import com.admin.salonmaster.dto.SalonDTO;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class SalonController {

    private SalonService salonService;

    @PostMapping("/addSalon")
    public ResponseEntity<Object> addSalon(@RequestBody Salon salon){
        return salonService.addSalon(salon);
    }

    @PutMapping("/updateSalon")
    public ResponseEntity<Object> updateSalon(@RequestBody Salon salon){
        return salonService.updateSalon(salon);
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

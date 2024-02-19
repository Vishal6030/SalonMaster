package com.admin.salonmaster.service;

import com.admin.salonmaster.entity.Salon;
import org.springframework.http.ResponseEntity;

public interface SalonService {
    public ResponseEntity<Object> addSalon(Salon salon);
    public ResponseEntity<Object> updateSalon(Salon salon);
    public ResponseEntity<Object> viewSalonList();
    public ResponseEntity<Object> getSalonDataById(Long salonId);
}

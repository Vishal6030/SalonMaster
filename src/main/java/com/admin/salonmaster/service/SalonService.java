package com.admin.salonmaster.service;

import com.admin.salonmaster.dto.SalonDTO;
import com.admin.salonmaster.entity.Salon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface SalonService {
    public ResponseEntity<Object> addSalon(SalonDTO salonDTO);
    public ResponseEntity<Object> updateSalon(SalonDTO salonDTO);
    public ResponseEntity<Object> viewSalonList();
    public ResponseEntity<Object> getSalonDataById(Long salonId);
    public ResponseEntity<Object> updateSalonStatus(Long salonId, Boolean status);
}

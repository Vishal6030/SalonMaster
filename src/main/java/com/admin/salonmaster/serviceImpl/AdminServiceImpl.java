package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.entity.Admin;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.repository.AdminRepo;
import com.admin.salonmaster.repository.SalonRepo;
import com.admin.salonmaster.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    private EmailService emailService;
    private AdminRepo adminRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private SalonRepo salonRepo;
    @Override
    public ResponseEntity<Object> addAdmin(Admin admin) {
        ResponseDTO response = new ResponseDTO();

        Salon existing = salonRepo.findById(admin.getSalonId()).orElse(null);
        if (existing == null) {
            response.setMessage("Salon id not exists!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
//        emailService.sendSimpleMail(emp.getEmail(), "Login password Details", sendPasswordEmail(userEntity.getPassword(), emp));

        admin.setPassword(passwordEncoder(admin.getPassword()));

        adminRepo.save(admin);

        response.setMessage("Admin created Successfully!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> unlockLoginStatus(String salonId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> sentEmail(String email) {
        return null;
    }

    public String passwordEncoder(String password) {
        return passwordEncoder.encode(password);
    }
}

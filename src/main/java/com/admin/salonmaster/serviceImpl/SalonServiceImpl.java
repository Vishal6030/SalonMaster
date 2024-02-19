package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.repository.SalonRepo;
import com.admin.salonmaster.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonRepo salonRepo;

    @Override
    public ResponseEntity<Object> addSalon(Salon salon) {
        ResponseDTO response= new ResponseDTO();
        try{
            return new ResponseEntity<>(salonRepo.save(salon), HttpStatus.OK);
        }catch(Exception e){
            response.setMessage("Not able to add salon!");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateSalon(Salon salon) {
        ResponseDTO response= new ResponseDTO();
        try{
            return new ResponseEntity<>(salonRepo.save(salon), HttpStatus.OK);
        }catch(Exception e){
            response.setMessage("Salon details not updated, Please give all field details!");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<Object> viewSalonList() {
        ResponseDTO response= new ResponseDTO();
        try{
            return new ResponseEntity<>(salonRepo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            response.setMessage("No salon List Found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<Object> getSalonDataById(Long salonId) {
        ResponseDTO response= new ResponseDTO();
        try{
            return new ResponseEntity<>(salonRepo.findById(salonId), HttpStatus.OK);
        }catch(Exception e){
            response.setMessage("No Salon found with this salonId !");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}

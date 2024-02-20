package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.dto.SalonDTO;
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
    public ResponseEntity<Object> addSalon(SalonDTO salonDTO) {
        ResponseDTO response = new ResponseDTO();
        try {
            Salon salon = convertDTOToEntity(salonDTO); // Convert DTO to Entity
            return new ResponseEntity<>(salonRepo.save(salon), HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Not able to add salon!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Object> updateSalon(SalonDTO salonDTO) {
        ResponseDTO response= new ResponseDTO();
        if(salonRepo.findById(salonDTO.getSalonId()).isEmpty()){
            response.setMessage("Salon Id is not found! Please check once more!");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        try{
            Salon salon= convertDTOToEntity(salonDTO);
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

    private Salon convertDTOToEntity(SalonDTO salonDTO) {
        Salon salon = new Salon();
        salon.setSalonId(salonDTO.getSalonId());
        salon.setPhone(salonDTO.getPhone());
        salon.setAddress(salonDTO.getAddress());
        salon.setAddressUrl(salonDTO.getAddressUrl());
        salon.setSalonLogo(salonDTO.getSalonLogo());
        salon.setRegisteredOn(salonDTO.getRegisteredOn());
        salon.setTrialPeriodStartDate(salonDTO.getTrialPeriodStartDate());
        salon.setStatus(salonDTO.getStatus());
        salon.setQrCode(salonDTO.getQrCode());
        salon.setSms(salonDTO.getSms());
        salon.setCoupon(salonDTO.getCoupon());
        salon.setMembership(salonDTO.getMembership());
        return salon;
    }
}

package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.entity.Services;
import com.admin.salonmaster.repository.ServicesRepo;
import com.admin.salonmaster.service.ServicesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ServiceListImpl implements ServicesList {

    @Autowired
    private ServicesRepo servicesRepo;
    @Override
    public ResponseEntity<Object> addService(Services service) {
        ResponseDTO response= new ResponseDTO();
        try{
            return new ResponseEntity<>(servicesRepo.save(service), HttpStatus.OK);
        }catch(Exception e){
            response.setMessage("Not able to add Services! Please Try Again !");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateService(Services service) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateServiceStatus(Long serviceId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getServiceById(Long serviceId) {
        ResponseDTO response= new ResponseDTO();
        try{
            return new ResponseEntity<>(servicesRepo.findById(serviceId), HttpStatus.OK);
        }catch(Exception e){
            response.setMessage("Not able to add Services! Please Try Again !");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}

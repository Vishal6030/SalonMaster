package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.dto.ServicesDTO;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.entity.Services;
import com.admin.salonmaster.repository.SalonRepo;
import com.admin.salonmaster.repository.ServicesRepo;
import com.admin.salonmaster.service.ServicesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ServiceListImpl implements ServicesList {

    @Autowired
    private ServicesRepo servicesRepo;

    @Autowired
    private SalonRepo salonRepo;
    @Override
    public ResponseEntity<Object> addService(ServicesDTO servicesDTO) {
        ResponseDTO response= new ResponseDTO();
        try{
            Services services= new Services();
            services.setServiceName(servicesDTO.getServiceName());
            services.setDetails(servicesDTO.getDetails());
            services.setServicePic(servicesDTO.getServicePic());
            services.setPrice(servicesDTO.getPrice());
            services.setDiscountPrice(servicesDTO.getDiscountPrice());
            services.setStatus(servicesDTO.getStatus());
            services.setServiceType(servicesDTO.getServiceType());

            Salon salon= salonRepo.findById(servicesDTO.getSalonId()).orElse(null);
            services.setSalon(salon);
            return new ResponseEntity<>(servicesRepo.save(services), HttpStatus.OK);
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
    public ResponseEntity<Object> updateServiceStatus(Long serviceId, Boolean status) {
        ResponseDTO response= new ResponseDTO();
        Services services = servicesRepo.findById(serviceId).orElse(null);
        if(services!=null){
            services.setStatus(status);
            return new ResponseEntity<>(servicesRepo.save(services), HttpStatus.OK);
        }
        response.setMessage("Not able to update Services! Please Try Again !");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
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

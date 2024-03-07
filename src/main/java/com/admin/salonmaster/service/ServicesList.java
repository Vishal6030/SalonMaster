package com.admin.salonmaster.service;

import com.admin.salonmaster.dto.ServicesDTO;
import com.admin.salonmaster.entity.Services;
import org.springframework.http.ResponseEntity;

public interface ServicesList {

    ResponseEntity<Object> addService(ServicesDTO ServicesDTO);
    ResponseEntity<Object> updateService(Services service);
    ResponseEntity<Object> updateServiceStatus(Long serviceId, Boolean status);
    ResponseEntity<Object> getServiceById(Long serviceId);

}

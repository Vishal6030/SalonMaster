package com.admin.salonmaster.service;

import com.admin.salonmaster.entity.Services;
import org.springframework.http.ResponseEntity;

public interface ServicesList {

    ResponseEntity<Object> addService(Services service);
    ResponseEntity<Object> updateService(Services service);
    ResponseEntity<Object> updateServiceStatus(Long serviceId);
    ResponseEntity<Object> getServiceById(Long serviceId);

}

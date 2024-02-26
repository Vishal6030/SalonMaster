package com.admin.salonmaster.service;

import com.admin.salonmaster.dto.SalonDTO;
import com.admin.salonmaster.entity.Package;
import org.springframework.http.ResponseEntity;

public interface PackageService {
    public ResponseEntity<Object> addPackage(Package packages);
    public ResponseEntity<Object> updatePackage(Package packages);
    public ResponseEntity<Object> viewServicesByPackageId(Long packageId);
    public ResponseEntity<Object> getPackageById(Long packageId);
    public ResponseEntity<Object> updatePackageStatus(Long packageId, Boolean status);
}

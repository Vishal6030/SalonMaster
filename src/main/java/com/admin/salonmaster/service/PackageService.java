package com.admin.salonmaster.service;


import com.admin.salonmaster.dto.PackageDTO;
import com.admin.salonmaster.entity.Package;
import org.springframework.http.ResponseEntity;

public interface PackageService {
    public ResponseEntity<Object> addPackage(PackageDTO packageDTO);
    public ResponseEntity<Object> updatePackage(PackageDTO packageDTO);
    public ResponseEntity<Object> viewServicesByPackageId(Long packageId);
    public ResponseEntity<Object> getPackageById(Long packageId);
    public ResponseEntity<Object> updatePackageStatus(Long packageId, Boolean status);

}

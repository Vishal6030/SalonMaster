package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.entity.Package;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.repository.PackageRepo;
import com.admin.salonmaster.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepo packageRepo;
    @Override
    public ResponseEntity<Object> addPackage(Package packages) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updatePackage(Package packages) {
        return null;
    }

    @Override
    public ResponseEntity<Object> viewServicesByPackageId(Long packageId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getPackageById(Long packageId) {
        Package packages= packageRepo.findById(packageId).orElse(null);
        if(packages !=null){
            return new ResponseEntity<>(packages, HttpStatus.OK);
        }else{
            ResponseDTO response= new ResponseDTO();
            response.setMessage("Invalid Salon Id!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> updatePackageStatus(Long packageId, Boolean status) {
        ResponseDTO response= new ResponseDTO();
        Package packages= packageRepo.findById(packageId).orElse(null);
        if(packages !=null){
            packages.setStatus(status);
            packageRepo.save(packages);
            response.setMessage("Package status updated successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setMessage("Package id not found!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

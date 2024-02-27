package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.PackageDTO;
import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.entity.Package;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.entity.Services;
import com.admin.salonmaster.repository.PackageRepo;
import com.admin.salonmaster.repository.SalonRepo;
import com.admin.salonmaster.repository.ServicesRepo;
import com.admin.salonmaster.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private SalonRepo salonRepo;

    @Autowired
    private ServicesRepo servicesRepo;

    @Override
    public ResponseEntity<Object> addPackage(PackageDTO packageDTO) {
        Salon salon= salonRepo.findById(packageDTO.getSalonId()).orElse(null);
        if(salon== null){
            ResponseDTO response= new ResponseDTO();
            response.setMessage("Salon Id is invalid");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }else{
            Package packages=new Package();
            packages.setPackageName(packageDTO.getPackageName());
            packages.setPrice(packageDTO.getPrice());
            packages.setDiscountPrice(packageDTO.getDiscountPrice());
            packages.setStartDate(packageDTO.getStartDate());
            packages.setEndDate(packageDTO.getEndDate());
            packages.setStatus(packageDTO.getStatus());
            packages.setServices(packageDTO.getServices());
            packages.setSalon(salon);

            packageRepo.save(packages);
            return new ResponseEntity<>(packageRepo.save(packages),HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<Object> updatePackage(PackageDTO packageDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> viewServicesByPackageId(Long packageId) {
        Optional<Package> packageOptional = packageRepo.findById(packageId);
        if (packageOptional.isPresent()) {
            Package packageEntity = packageOptional.get();
            List<Long> serviceIds = packageEntity.getServices();
            List<Services> services = servicesRepo.findAllById(serviceIds);
            return new ResponseEntity<>(services, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Package not found", HttpStatus.NOT_FOUND);
        }
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

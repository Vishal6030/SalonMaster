package com.admin.salonmaster.controller;

import com.admin.salonmaster.dto.PackageDTO;
import com.admin.salonmaster.entity.Package;
import com.admin.salonmaster.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/addPackage")
    public ResponseEntity<Object> addPackage(@RequestBody PackageDTO packageDTO){
        return packageService.addPackage(packageDTO);
    }

    @PutMapping("/updatePackages")
    public ResponseEntity<Object> updatePackage(@RequestBody PackageDTO packageDTO){
        return packageService.updatePackage(packageDTO);
    }

    @GetMapping("/getServicesByPackageId/{packageId}")
    public ResponseEntity<Object> viewServicesByPackageId(@PathVariable Long packageId){
        return packageService.viewServicesByPackageId(packageId);
    }

    @GetMapping("/getPackageById/{packageId}")
    public ResponseEntity<Object> getPackageById(@PathVariable Long packageId){
        return packageService.getPackageById(packageId);
    }

    @PatchMapping("/updateStatusById/{packageId}")
    public ResponseEntity<Object> updatePackageStatus(@PathVariable Long packageId,@RequestParam Boolean status){
        return packageService.updatePackageStatus(packageId,status);
    }
}

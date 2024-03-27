package com.admin.salonmaster.serviceImpl;

import com.admin.salonmaster.dto.AdminLoginDTO;
import com.admin.salonmaster.dto.AdminPhoneLoginDTO;
import com.admin.salonmaster.dto.ChangePasswordDTO;
import com.admin.salonmaster.dto.ResponseDTO;
import com.admin.salonmaster.entity.Admin;
import com.admin.salonmaster.entity.Salon;
import com.admin.salonmaster.repository.AdminRepo;
import com.admin.salonmaster.repository.SalonRepo;
import com.admin.salonmaster.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;


@Service
public class AdminServiceImpl implements AdminService {


    private EmailService emailService;

    @Autowired
    private AdminRepo adminRepo;

    //private PasswordEncoder passwordEncoder;

    @Autowired
    private SalonRepo salonRepo;
    @Override
    public ResponseEntity<Object> addAdmin(Admin admin) {
        ResponseDTO response = new ResponseDTO();

        Salon existing = salonRepo.findById(admin.getSalonId()).orElse(null);
        if (existing == null) {
            response.setMessage("Salon id not exists!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
//        emailService.sendSimpleMail(emp.getEmail(), "Login password Details", sendPasswordEmail(userEntity.getPassword(), emp));
        String encodedString = Base64.getEncoder().encodeToString(admin.getPassword().getBytes());
        admin.setPassword(encodedString);

        adminRepo.save(admin);

        response.setMessage("Admin created Successfully!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> loginByUsernameOrPhone(AdminLoginDTO adminLoginDTO) {
        ResponseDTO response= new ResponseDTO();
        Admin admin= new Admin();
        if(adminLoginDTO.getUsername() != null && ! adminLoginDTO.getUsername().isEmpty()){
             admin= adminRepo.findByUsername(adminLoginDTO.getUsername());
            if(admin == null){
                response.setMessage(("Username is invalid!"));
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
        }else{
             admin= adminRepo.findByPhone(adminLoginDTO.getPhone());
            if(admin == null){
                response.setMessage(("Phone number is invalid!"));
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
        }

        String encodedString = Base64.getEncoder().encodeToString(adminLoginDTO.getPassword().getBytes());

        if(Objects.equals(admin.getPassword(), encodedString)){
            return new ResponseEntity<>(admin,HttpStatus.OK);
        }else{
            response.setMessage("Password is wrong! Please Try again or contact administrator.");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> loginByPhone(AdminPhoneLoginDTO adminPhoneLoginDTO) {
        ResponseDTO response= new ResponseDTO();
        Admin admin= adminRepo.findByPhone(adminPhoneLoginDTO.getPhone());
        if(admin == null){
            response.setMessage(("Phone number is not registered!"));
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        String encodedString = Base64.getEncoder().encodeToString(adminPhoneLoginDTO.getPassword().getBytes());

        if(Objects.equals(admin.getPassword(), encodedString)){
            return new ResponseEntity<>(admin,HttpStatus.OK);
        }else{
            response.setMessage("Password is wrong! Please Try again or contact administrator.");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> changePassword(ChangePasswordDTO changePasswordDTO) {
        ResponseDTO response= new ResponseDTO();
        Admin admin= adminRepo.findByUsername(changePasswordDTO.getUsername());
        if(admin == null){
            response.setMessage(("username is not valid!"));
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        String encodedString = Base64.getEncoder().encodeToString(changePasswordDTO.getOldPassword().getBytes());

        if(Objects.equals(admin.getPassword(), encodedString)){
            String newEncodedString = Base64.getEncoder().encodeToString(changePasswordDTO.getNewPassword().getBytes());
            admin.setPassword(newEncodedString);
            adminRepo.save(admin);
            response.setMessage("Password Changed Successfully!");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            response.setMessage("Password is wrong! Please Try again or contact administrator.");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> sentEmail(String email) {
        return null;
    }

//    public String passwordEncoder(String password) {
//        return passwordEncoder.encode(password);
//    }
}

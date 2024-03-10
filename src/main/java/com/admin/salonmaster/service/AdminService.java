package com.admin.salonmaster.service;

import com.admin.salonmaster.dto.AdminLoginDTO;
import com.admin.salonmaster.entity.Admin;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<Object> addAdmin(Admin admin);
    ResponseEntity<Object> loginByUsername(AdminLoginDTO adminLoginDTO);
//    ResponseEntity<Object> changePassword(String email, ChangePasswordDTO changePasswordDTO);
    ResponseEntity<Object> sentEmail(String email);
//    ResponseEntity<Object> forgetPassword(String email, ForgetPasswordDTO forgetPasswordDTO);
//    OtpValidation validateOtp(OtpValidateDTO otpValidateDTO);
}

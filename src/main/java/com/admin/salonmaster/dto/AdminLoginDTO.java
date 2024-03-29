package com.admin.salonmaster.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginDTO {
    private String username;
    private String phone;
    private String password;
}

package com.admin.salonmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SalonDTO {
    private Long salonId;
    private String phone;
    private String address;
    private String addressUrl;
    private String salonLogo;
    private Date registeredOn;
    private Boolean status; //  Enable/Disable of salon status
    private String qrCode;
    private Boolean sms;
    private Boolean coupon;
    private Boolean membership;
}

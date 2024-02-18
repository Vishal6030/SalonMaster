package com.admin.salonmaster.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "salon")
    private List<Customer> customer;

    @OneToMany(mappedBy = "salon")
    private List<Services> services;


}

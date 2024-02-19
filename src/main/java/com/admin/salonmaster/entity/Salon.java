package com.admin.salonmaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ElementCollection
    @CollectionTable(name = "salons_packageIds", joinColumns = @JoinColumn(name = "salon_id"))
    @Column(name = "package_id")
    private List<Long> packageIds;

}

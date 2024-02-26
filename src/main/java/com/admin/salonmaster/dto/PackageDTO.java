package com.admin.salonmaster.dto;

import com.admin.salonmaster.entity.Salon;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class PackageDTO {
    private Long packageId;
    private String packageName;
    private Long price;
    private Long discountPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;
    private Long salonId;
}

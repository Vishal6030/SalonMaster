package com.admin.salonmaster.dto;

import com.admin.salonmaster.entity.Package;
import com.admin.salonmaster.entity.Services;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Data
public class BookingDTO {
    private Long bookingId;
    private LocalDateTime bookingDate;
    private Long customerId;
    private LocalDate slotAllocatedDate;
    private LocalTime slotAllocatedTime;
    private Boolean status;
    private String remarks;
    private Boolean advancePayment;
    private Boolean IsBookingConfirm;
    private List<Package> packages;
    private List<Services> services;
}

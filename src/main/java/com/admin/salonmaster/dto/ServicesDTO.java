package com.admin.salonmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDTO {
    private Long serviceId;
    private String serviceName;
    private String details;
    private String servicePic;
    private Long price;
    private Long discountPrice;
    private Boolean status;
    private String serviceType;
    private Long salonId;
}

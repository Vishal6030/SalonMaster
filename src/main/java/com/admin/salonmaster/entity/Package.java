package com.admin.salonmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;
    private String packageName;
    private Long price;
    private Long discountPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean status;

//    @ManyToMany
//    @JoinTable(
//            name = "package_service",
//            joinColumns = @JoinColumn(name = "package_id"),
//            inverseJoinColumns = @JoinColumn(name = "service_id")
//    )
//    private List<Services> services;

    @ElementCollection
    @CollectionTable(name = "package_service", joinColumns = @JoinColumn(name = "package_id"))
    @Column(name = "service_id")
    private List<Long> services;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    @JsonIgnore
    private Salon salon;

}

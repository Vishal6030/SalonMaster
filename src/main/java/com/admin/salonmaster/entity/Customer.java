package com.admin.salonmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String phone;
    private String email;
    private LocalDate startDate;
    private Integer birthDate;
    private Integer birthMonth;
    private String gender;
    private String type; //Gold,Silver or Diamond.

    @ManyToOne
    @JoinColumn(name = "salon_id")
    @JsonIgnore
    private Salon salon;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    public Customer() {
        this.startDate = LocalDate.now();
    }
}

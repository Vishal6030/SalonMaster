package com.admin.salonmaster.repository;

import com.admin.salonmaster.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo extends JpaRepository<Salon,Long> {

}

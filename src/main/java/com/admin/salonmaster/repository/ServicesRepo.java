package com.admin.salonmaster.repository;

import com.admin.salonmaster.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<Services, Long> {
}

package com.admin.salonmaster.repository;

import com.admin.salonmaster.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);

    Admin findByPhone(String phone);
}

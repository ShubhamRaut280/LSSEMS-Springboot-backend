package com.shubham.localservices.Repository;

import com.shubham.localservices.Models.Db.FreelancerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FreelanceRepository extends JpaRepository<FreelancerProfile, Long> {
    Optional<FreelancerProfile> findByuserId(Long id);
}

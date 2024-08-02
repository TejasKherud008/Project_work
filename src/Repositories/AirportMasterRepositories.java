package com.example.repositories;


import com.example.entities.AirportMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportMasterRepositories extends JpaRepository<AirportMaster, Long> {
    // You can add custom query methods here if needed
}


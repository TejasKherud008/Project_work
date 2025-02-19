package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.InvoiceHeader;

@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {
	
}

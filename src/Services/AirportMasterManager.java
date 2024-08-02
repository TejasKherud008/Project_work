package com.example.Services;

import java.util.List;
import java.util.Optional;

import com.example.entities.AirportMaster;

public interface AirportMasterManager {
	List<AirportMaster> getAllAirports();
	Optional<AirportMaster> getAirportById(Long id);
	AirportMaster createOrUpdateAirport(AirportMaster airport);
	void deleteAirport(Long id);
}

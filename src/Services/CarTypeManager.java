package com.example.Services;

import java.util.List;
import java.util.Optional;

import com.example.entities.CarType;

public interface CarTypeManager {

	List<CarType> getAllCarTypes();
	Optional<CarType> getCarTypeById(Long id);
	CarType saveCarType(CarType carType);
	void deleteCarType(Long id);
	
}

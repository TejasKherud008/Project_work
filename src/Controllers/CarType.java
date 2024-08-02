package com.example.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Services.CarTypeManager;
import com.example.entities.CarType;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartypes")

public class CarTypeController {

    private  CarTypeManager carTypeManager;

    @Autowired
    public CarTypeController(CarTypeManager carTypeManager) {
        this.carTypeManager =carTypeManager;
    }

    @GetMapping
    public List<CarType> getAllCarTypes() {
        return carTypeManager.getAllCarTypes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarType> getCarTypeById(@PathVariable Long id) {
        Optional<CarType> carType = carTypeManager.getCarTypeById(id);
        return carType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createCarType")
    public CarType createCarType(@RequestBody CarType carType) {
        return carTypeManager.saveCarType(carType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarType> updateCarType(@PathVariable Long id, @RequestBody CarType carType) {
        if (!carTypeManager.getCarTypeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carType.setId(id);
        return ResponseEntity.ok(carTypeManager.saveCarType(carType));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarType(@PathVariable Long id) {
        if (!carTypeManager.getCarTypeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        carTypeManager.deleteCarType(id);
        return ResponseEntity.noContent().build();
    }
}

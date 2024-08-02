
package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.AirportMasterManager;
import com.example.entities.AirportMaster;

@RestController
@RequestMapping("/api/airports")
public class AirportMasterController {

    @Autowired
    private AirportMasterManager airportService;

    @GetMapping
    public ResponseEntity<List<AirportMaster>> getAllAirports() {
        List<AirportMaster> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportMaster> getAirportById(@PathVariable("id") Long id) {
        Optional<AirportMaster> airport = airportService.getAirportById(id);
        return airport.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AirportMaster> createAirport( @RequestBody AirportMaster airport) {
        AirportMaster createdAirport = airportService.createOrUpdateAirport(airport);
        return new ResponseEntity<>(createdAirport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportMaster> updateAirport(@PathVariable("id") Long id,  @RequestBody AirportMaster airport) {
        if (!airportService.getAirportById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airport.setId(id);
        AirportMaster updatedAirport = airportService.createOrUpdateAirport(airport);
        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable("id") Long id) {
        if (!airportService.getAirportById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}


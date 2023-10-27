package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Models.Location;
import com.demo.fijinv.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    public LocationRepository locationRepository;

    @GetMapping
    public List<Location> getAllLocation(){
      return locationRepository.findAll();
    }

    @PostMapping
    public Location createNewLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable Long id){
        locationRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.demo.fijinv.Conteollers;


import com.demo.fijinv.Models.Location;
import com.demo.fijinv.Models.Plants;
import com.demo.fijinv.Repositories.LocationRepository;
import com.demo.fijinv.Repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/plants")
public class PlantsController {
    @Autowired
    public PlantRepository plantRepository;

    @GetMapping
    public List<Plants> getAllLocation(){
        return plantRepository.findAll();
    }

    @PostMapping
    public Plants createNewPlants(@RequestBody Plants plants){
        return plantRepository.save(plants);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Plants> deleteLocation(@PathVariable Long id){
        plantRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
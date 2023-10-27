package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Models.Country;
import com.demo.fijinv.Models.Location;
import com.demo.fijinv.Models.Plants;
import com.demo.fijinv.Repositories.Countryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    public Countryrepository countryrepository;

    @GetMapping
    public List<Country> getAllCountries(){
        return countryrepository.findAll();
    }

    @PostMapping
    public Country createNewCountry(@RequestBody Country country){
        return countryrepository.save(country);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id){
        countryrepository.deleteById(id);
        return new ResponseEntity<Country>(HttpStatus.OK);
    }

}

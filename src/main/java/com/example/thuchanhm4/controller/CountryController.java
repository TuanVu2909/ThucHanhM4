package com.example.thuchanhm4.controller;

import com.example.thuchanhm4.model.City;
import com.example.thuchanhm4.model.Country;
import com.example.thuchanhm4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private ICountryService iCountryService;


    @GetMapping
    public ResponseEntity<Iterable<Country>> finAll(){
        List<Country> countries = (List<Country>) iCountryService.findAll();
        if (countries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(countries,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Country>> findOne(@PathVariable Long id){
        Optional<Country> countryOptional = iCountryService.findOne(id);
        if (!countryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(countryOptional,HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country){
        Country country1 = iCountryService.save(country);
        if (country1 != null){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody Country country){
        Optional<Country>  country1 = iCountryService.findOne(id);
        if (!country1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            country.setId(id);
            iCountryService.save(country);
            return new ResponseEntity<>(country,HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Country> delete(@PathVariable Long id){
        Optional<Country> countryOptional = iCountryService.findOne(id);
        if (!countryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            iCountryService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

package com.example.thuchanhm4.controller;

import com.example.thuchanhm4.model.City;
import com.example.thuchanhm4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private ICityService iCityService;
    @GetMapping
    public ResponseEntity<Iterable<City>> finAll(){
        List<City> cities = (List<City>) iCityService.findAll();
        if (cities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(cities,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> findOne(@PathVariable Long id){
        Optional<City> cityOptional = iCityService.findOne(id);
        if (!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(cityOptional,HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city){
        City city1 = iCityService.save(city);
        if (city1 != null){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city){
        Optional<City> city1 = iCityService.findOne(id);
        if (!city1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            city.setId(id);
            iCityService.save(city);
            return new ResponseEntity<>(city,HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
        Optional<City> cityOptional = iCityService.findOne(id);
        if (!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            iCityService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

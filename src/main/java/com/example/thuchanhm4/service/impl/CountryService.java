package com.example.thuchanhm4.service.impl;

import com.example.thuchanhm4.model.Country;
import com.example.thuchanhm4.repository.ICountryRepository;
import com.example.thuchanhm4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepository iCountryRepository;
    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Optional<Country> findOne(Long id) {
        return iCountryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return iCountryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        iCountryRepository.deleteById(id);
    }
}

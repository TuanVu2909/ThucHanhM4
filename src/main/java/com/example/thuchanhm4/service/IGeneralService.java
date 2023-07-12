package com.example.thuchanhm4.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findOne(Long id);
    T save(T t);
    void remove(Long id);
}

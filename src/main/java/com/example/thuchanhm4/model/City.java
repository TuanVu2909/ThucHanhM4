package com.example.thuchanhm4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private int people;
    private double GDP;
    private String depict;
    @ManyToOne
    private Country country;

}

package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal balance;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.ALL)
    private Set<Home> homes = new HashSet<>();
}

package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity // JPA
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Person() {
        passport = new Passport();
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "passport_id", referencedColumnName = "id"),
            @JoinColumn(name = "passport_series", referencedColumnName = "series")
    })
    private Passport passport;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.ALL)
    private Set<Home> homes = new HashSet<>();
}

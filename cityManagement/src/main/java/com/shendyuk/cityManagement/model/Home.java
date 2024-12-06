package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private int number;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "person_home",
            joinColumns = @JoinColumn(name = "home_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id")
    )
    private Set<Person> persons = new HashSet<>();
}

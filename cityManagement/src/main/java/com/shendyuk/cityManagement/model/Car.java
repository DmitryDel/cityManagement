package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String manufactureYear;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;
}

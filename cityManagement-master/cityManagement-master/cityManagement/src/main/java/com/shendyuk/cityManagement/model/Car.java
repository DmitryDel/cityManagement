package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String manufactureYear;

    @ManyToOne
    private Person owner;
}

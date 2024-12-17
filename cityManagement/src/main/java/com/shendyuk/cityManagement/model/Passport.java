package com.shendyuk.cityManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String series;
    private LocalDate issueData;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
}

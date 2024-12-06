package com.shendyuk.cityManagement.model;

import com.shendyuk.cityManagement.service.PassportService;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true)
    private String series;

//    @NonNull
    private LocalDate issueData;

    //TODO создать пустой паспорт, поля заполнять в сервисе
    public Passport() {
        this.series = PassportService.generatePassportSeries();
        this.issueData = LocalDate.now();
    }

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Person person;
}

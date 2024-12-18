package com.shendyuk.cityManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseDTO {
    private Long id;
    private String name;
    private String idPassport;
    private String passportSeries;
}

package com.shendyuk.cityManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PassportResponseDTO {
    Long id;
    String series;
    LocalDate issueData;
}

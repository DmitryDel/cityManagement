package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Passport;

import java.util.List;

public interface PassportService {
    Passport createNewPassport();

    String generatePassportSeries();

    List<Passport> findAll();

    Passport findById(Long id);

    Passport save(Passport passport);

    void delete(Passport passport);
}

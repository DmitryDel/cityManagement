package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.exception.EntityNotFoundException;
import com.shendyuk.cityManagement.model.Passport;
import com.shendyuk.cityManagement.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PassportService {
    private final PassportRepository passportRepository;

    public Passport createNewPassport() {
        Passport passport = new Passport();
        passport.setSeries(generatePassportSeries());
        passport.setIssueData(LocalDate.now());
        return passport;
    }

    public static String generatePassportSeries() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    public Passport findById(Long id) {
        return passportRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Паспорт по указанному ID: " + id + " не найден."));
    }

    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }
}

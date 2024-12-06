package com.shendyuk.cityManagement.repository;

import com.shendyuk.cityManagement.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}

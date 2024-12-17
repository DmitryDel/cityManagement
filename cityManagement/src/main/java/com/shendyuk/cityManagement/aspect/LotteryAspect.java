package com.shendyuk.cityManagement.aspect;

import com.shendyuk.cityManagement.model.Person;
import com.shendyuk.cityManagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LotteryAspect {

    private final PersonRepository personRepository;

    @Around(value = "@annotation(com.shendyuk.cityManagement.aspect.RobinHood)", argNames = "proceedingJoinPoint")
    public Object handle(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Person person;

            do person = (Person) proceedingJoinPoint.proceed(); while (person.getCars() != null);

            BigDecimal currentBalance = Optional.ofNullable(person.getBalance())
                    .orElse(BigDecimal.ZERO).add(BigDecimal.valueOf(1000));
            person.setBalance(currentBalance);

            personRepository.save(person);

            log.info("Аспект запущен.");
            return person;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

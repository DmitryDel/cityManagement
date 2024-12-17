package com.shendyuk.cityManagement.aspect;

import com.shendyuk.cityManagement.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LotteryAspect {

    @Around(value = "@annotation(com.shendyuk.cityManagement.aspect.RobinHood)", argNames = "proceedingJoinPoint")
    public Object handel(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            //TODO написать логику проверки машины, если есь машина, то найти другого пользователя
            Person person = (Person) proceedingJoinPoint.proceed();
            log.info("Аспект запущен.");
            return person;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LotteryService {
    private final PersonService personService;

    @Scheduled(fixedDelay = 3000)
    public void startLottery() {
        log.info("Lottery started.");
        Person person = personService.randomPerson();
    }
}

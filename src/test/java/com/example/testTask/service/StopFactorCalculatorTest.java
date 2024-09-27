package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.SettingsRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StopFactorCalculatorTest {

    @Test
    void calculateStopFactor() {
        StopFactorCalculator stopFactorCalculator = new StopFactorCalculator();
        RegPerson regPerson = RegPerson.builder().firstName("Mike").middleName("Di").lastName("Smith").build();
        VerifiedName verifiedName = VerifiedName.builder().firstName("Mike").middleName("Di").lastName("Smith").build();
        boolean actual = stopFactorCalculator.calculateStopFactor(regPerson, verifiedName);
        assertTrue(actual);
    }

    @Test
    void getCombinations(){

    }

    @Test
    void levenshteinDistance(){

    }
}
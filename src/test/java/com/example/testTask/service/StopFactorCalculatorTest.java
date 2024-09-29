package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.VerifiedName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
class StopFactorCalculatorTest {

    @Test
    void calculateStopFactor() {
        StopFactorCalculator stopFactorCalculator = new StopFactorCalculator();
        RegPerson regPerson = RegPerson.builder().firstName("Mike").middleName("Di").lastName("Smith").build();
        VerifiedName verifiedName = VerifiedName.builder().firstName("Mike").middleName("Di").lastName("Smith").build();
        boolean actual = stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, new Settings());
        assertTrue(actual);
    }

    @Test
    void getCombinations(){

    }

    @Test
    void levenshteinDistance(){

    }
}
package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.impl.StopFactorCalculatorImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class StopFactorCalculatorTest {

    @Test
    void testGetCombinations() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        List<String> combinations = stopFactorCalculator.getCombinations("John", "Doe", "A");
        assertEquals(3, combinations.size());
        assertTrue(combinations.contains("JohnDoe"));
        assertTrue(combinations.contains("JohnA"));
        assertTrue(combinations.contains("DoeA"));
    }

    @Test
    void testLevenshteinDistance() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        assertEquals(0, stopFactorCalculator.levenshteinDistance("test", "test"));
        assertEquals(1, stopFactorCalculator.levenshteinDistance("test", "tent"));
        assertEquals(4, stopFactorCalculator.levenshteinDistance("test", "tstt"));
        assertEquals(3, stopFactorCalculator.levenshteinDistance("kitten", "sitting"));
    }

    @Test
    void testCalculateStopFactor() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        RegPerson regPerson = new RegPerson(1L, "John", "Doe", "A");
        VerifiedName verifiedName = new VerifiedName(2L,"John", "Doe", "B");
        Settings settings = new Settings();
        settings.setDistanceRatioThreshold(1.0);

        boolean result = stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, settings);
        assertTrue(result);

        settings.setDistanceRatioThreshold(0.5);
        result = stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, settings);
        assertFalse(result);
    }
}

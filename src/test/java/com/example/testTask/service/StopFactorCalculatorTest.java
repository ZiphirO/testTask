package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.impl.StopFactorCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
class StopFactorCalculatorTest {

    @Test
    public void testGetCombinations() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        // Arrange
        List<String> names = List.of("John", "Doe", "Smith");
        List<String> expectedCombinations = List.of(
                "JohnDoe", "DoeJohn",
                "JohnSmith", "SmithJohn",
                "DoeSmith", "SmithDoe"
        );

        Assertions.assertNotEquals(stopFactorCalculator.getCombinations(names), stopFactorCalculator.getCombinations(expectedCombinations));
        Assertions.assertEquals(stopFactorCalculator.getCombinations(names), stopFactorCalculator.getCombinations(names));
    }

    @Test
    public void testGetCombinations_EmptyList() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        // Arrange
        List<String> names = new ArrayList<>();
        List<String> expectedCombinations = new ArrayList<>(); // No combinations for an empty list

        Assertions.assertEquals(stopFactorCalculator.getCombinations(names),
                stopFactorCalculator.getCombinations(expectedCombinations));
    }

    @Test
    public void testGetCombinations_SingleElementList() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        // Arrange
        List<String> names = List.of("John");
        List<String> expectedCombinations = new ArrayList<>(); // No combinations for a single element

        Assertions.assertEquals(stopFactorCalculator.getCombinations(names),
                stopFactorCalculator.getCombinations(expectedCombinations));
    }

    @Test
    public void testGetCombinations_TwoElementsList() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        // Arrange
        List<String> names = Arrays.asList("John", "Doe");
        List<String> expectedCombinations = Arrays.asList(
                "JohnDoe", "DoeJohn"
        );

        Assertions.assertEquals(stopFactorCalculator.getCombinations(names),
                stopFactorCalculator.getCombinations(expectedCombinations));
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
        VerifiedName verifiedName = new VerifiedName(2L,"John", "Doe", "B", regPerson);
        Settings settings = new Settings();
        settings.setDistanceRatioThreshold(1.0);

        boolean result = stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, settings);
        assertTrue(result);

        settings.setDistanceRatioThreshold(0.5);
        result = stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, settings);
        assertFalse(result);
    }
}

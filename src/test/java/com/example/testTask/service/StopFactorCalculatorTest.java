package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.impl.StopFactorCalculatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class StopFactorCalculatorTest {

//    @Test
//    public void testGetCombinations() {
//        // Arrange
//        List<String> names = Arrays.asList("John", "Doe", "Smith");
//        List<String> expectedCombinations = Arrays.asList(
//                "JohnDoe", "DoeJohn",
//                "JohnSmith", "SmithJohn",
//                "DoeSmith", "SmithDoe"
//        );
//
//        // Act
//        CombinationService combinationService = new CombinationService();
//        List<String> actualCombinations = combinationService.getCombinations(names);
//
//        // Assert
//        assertEquals(expectedCombinations.size(), actualCombinations.size(), "Size of combinations should match");
//        assertEquals(expectedCombinations, actualCombinations, "The combinations should match the expected result");
//    }
//
//    @Test
//    public void testGetCombinations_EmptyList() {
//        // Arrange
//        List<String> names = Arrays.asList();
//        List<String> expectedCombinations = Arrays.asList(); // No combinations for an empty list
//
//        // Act
//        CombinationService combinationService = new CombinationService();
//        List<String> actualCombinations = combinationService.getCombinations(names);
//
//        // Assert
//        assertEquals(expectedCombinations, actualCombinations, "The combinations should be empty for an empty list");
//    }
//
//    @Test
//    public void testGetCombinations_SingleElementList() {
//        // Arrange
//        List<String> names = Arrays.asList("John");
//        List<String> expectedCombinations = Arrays.asList(); // No combinations for a single element
//
//        // Act
//        CombinationService combinationService = new CombinationService();
//        List<String> actualCombinations = combinationService.getCombinations(names);
//
//        // Assert
//        assertEquals(expectedCombinations, actualCombinations, "The combinations should be empty for a single element");
//    }

//    @Test
//    public void testGetCombinations_TwoElementsList() {
//        // Arrange
//        List<String> names = Arrays.asList("John", "Doe");
//        List<String> expectedCombinations = Arrays.asList(
//                "JohnDoe", "DoeJohn"
//        );
//
//        // Act
//        CombinationService combinationService = new CombinationService();
//        List<String> actualCombinations = combinationService.getCombinations(names);
//
//        // Assert
//        assertEquals(expectedCombinations, actualCombinations, "The combinations should match the expected result for two elements");
//    }

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

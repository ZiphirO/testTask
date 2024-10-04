package com.example.testTask.service;

import com.example.testTask.service.impl.StopFactorCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StopFactorCalculatorTest {

    @Test
    public void testGetCombinations() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();

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

        List<String> names = new ArrayList<>();
        List<String> expectedCombinations = new ArrayList<>();

        Assertions.assertEquals(stopFactorCalculator.getCombinations(names),
                stopFactorCalculator.getCombinations(expectedCombinations));
    }

    @Test
    public void testGetCombinations_SingleElementList() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();

        List<String> names = List.of("John");
        List<String> expectedCombinations = new ArrayList<>();

        Assertions.assertEquals(stopFactorCalculator.getCombinations(names),
                stopFactorCalculator.getCombinations(expectedCombinations));
    }

    @Test
    public void testGetCombinations_TwoElementsList() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();

        List<String> names = Arrays.asList("John", "Doe");
        List<String> expectedCombinations = Arrays.asList(
                "JohnDoe", "DoeJohn"
        );

        Assertions.assertNotEquals(stopFactorCalculator.getCombinations(names),
                stopFactorCalculator.getCombinations(expectedCombinations));
    }

    @Test
    public void testEmptyStrings() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        assertEquals(0, stopFactorCalculator.levenshteinDistance("", ""));
    }

    @Test
    public void testOneEmptyString() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        assertEquals(5, stopFactorCalculator.levenshteinDistance("hello", ""));
        assertEquals(5, stopFactorCalculator.levenshteinDistance("", "world"));
    }

    @Test
    public void testSameStrings() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        assertEquals(0, stopFactorCalculator.levenshteinDistance("test", "test"));
        assertNotEquals(0.9, stopFactorCalculator.levenshteinDistance("TEST", "test"));
    }

    @Test
    public void testDifferentStrings() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        assertEquals(3, stopFactorCalculator.levenshteinDistance("kitten", "sitting"));
        assertEquals(1, stopFactorCalculator.levenshteinDistance("flaw", "flaws"));
        assertEquals(2, stopFactorCalculator.levenshteinDistance("gumbo", "gambol"));
    }

    @Test
    public void testSingleCharacterStrings() {
        StopFactorCalculatorImpl stopFactorCalculator = new StopFactorCalculatorImpl();
        assertEquals(1, stopFactorCalculator.levenshteinDistance("a", "b"));
        assertEquals(1, stopFactorCalculator.levenshteinDistance("a", ""));
    }


}

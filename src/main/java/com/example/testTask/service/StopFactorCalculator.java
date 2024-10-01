package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.VerifiedName;

import java.util.List;

public interface StopFactorCalculator {

    boolean calculateStopFactor(RegPerson regPerson, VerifiedName verifiedName, Settings settings);

    List<String> getCombinations(List<String> names);

    static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }

    int levenshteinDistance(String str1, String str2);

}

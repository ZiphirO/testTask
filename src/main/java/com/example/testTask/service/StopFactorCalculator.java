package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.VerifiedName;

import java.util.List;

public interface StopFactorCalculator {

    boolean calculateStopFactor(RegPerson regPerson, VerifiedName verifiedName, Settings settings);

    List<String> getCombinations(List<String> names);

    int levenshteinDistance(String str1, String str2);

}

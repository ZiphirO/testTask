package com.example.testTask.service.impl;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.StopFactor;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.RegPersonService;
import com.example.testTask.service.StopFactorCalculator;
import com.example.testTask.service.StopFactorService;
import com.example.testTask.service.VerifiedNameService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class StopFactorCalculatorImpl implements StopFactorCalculator {

    @Autowired
    private  StopFactorService stopFactorService;
    @Autowired
    private  RegPersonService regPersonService;
    @Autowired
    private  VerifiedNameService verifiedNameService;

    @Override
    public  boolean calculateStopFactor(RegPerson regPerson, VerifiedName verifiedName, Settings settings){
        Double distanceRatioThreshold = settings.getDistanceRatioThreshold();
        List<String> regPersonCombinations = getCombinations(regPersonService.getRegPersonFields(regPerson));
        List<String> verifiedNameCombinations = getCombinations(verifiedNameService.getVerifiedNameFields(verifiedName));

        int maxDistance = 0;
        for (String regPersonCombination : regPersonCombinations) {
            for (String verifiedNameCombination : verifiedNameCombinations) {
                int distance = levenshteinDistance(regPersonCombination, verifiedNameCombination);
                maxDistance = Math.max(maxDistance, distance);
            }
        }
        StopFactor stopFactor = new StopFactor();
        boolean personStopFactor = Double.compare((double) maxDistance, distanceRatioThreshold) == 0;
        stopFactor.setPersonStopFactor(personStopFactor);
        stopFactor.setRegPerson(regPerson);
        stopFactorService.initStopFactor(stopFactor);

        return personStopFactor;
    }

    @Override
    public  List<String> getCombinations(List<String> names) {
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) {
                combinations.add(names.get(i) + names.get(j));
                combinations.add(names.get(j) + names.get(i));
            }
        }
        return combinations;
    }
    
    @Override
    public  int levenshteinDistance(String word1, String word2) {
        String str1 = word1.toUpperCase();
        String str2 = word2.toUpperCase();
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (Character.valueOf(str1.charAt(i - 1)).equals(Character.valueOf(str2.charAt(j - 1)))) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }
        return dp[len1][len2];
    }
}

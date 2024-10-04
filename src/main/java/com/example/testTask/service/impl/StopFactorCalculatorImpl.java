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
import java.util.Arrays;
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
        double maxNormalizedDistance = 0.0;

        for (String regPersonCombination : regPersonCombinations) {
            for (String verifiedNameCombination : verifiedNameCombinations) {
                int distance = levenshteinDistance(regPersonCombination, verifiedNameCombination);
                double normalizedDistance = (double) distance / Math.max(regPersonCombination.length(), verifiedNameCombination.length());
                maxNormalizedDistance = Math.max(maxNormalizedDistance, normalizedDistance);
            }
        }
        StopFactor stopFactor = new StopFactor();

        boolean personStopFactor = maxNormalizedDistance < distanceRatioThreshold;
        stopFactor.setPersonStopFactor(personStopFactor);
        stopFactor.setRegPerson(regPerson);
        stopFactorService.initStopFactor(stopFactor);

        System.out.println(maxNormalizedDistance);

        return personStopFactor;
    }

    @Override
    public  List<String> getCombinations(List<String> names) {
        List<String> combinations = new ArrayList<>();
        List<String> tpm = new ArrayList<>();
        for (String name : names){
            if (name.contains(" ")){
                String[] splited = name.split(" ");
                tpm.addAll(Arrays.asList(splited));
            }else tpm.add(name);
        }
        for (int i = 0; i < tpm.size(); i++) {
            for (int j = i + 1; j < tpm.size(); j++) {
                combinations.add(tpm.get(i) + tpm.get(j));
                combinations.add(tpm.get(j) + tpm.get(i));
            }
        }
        return combinations;
    }
    
    @Override
    public  int levenshteinDistance(String word1, String word2) {
        String str1 = word1.toUpperCase();
        String str2 = word2.toUpperCase();
        int[] Di_1 = new int[str2.length() + 1];
        int[] Di = new int[str2.length() + 1];

        for (int j = 0; j <= str2.length(); j++) {
            Di[j] = j; // (i == 0)
        }

        for (int i = 1; i <= str1.length(); i++) {
            System.arraycopy(Di, 0, Di_1, 0, Di_1.length);

            Di[0] = i; // (j == 0)
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
                Di[j] = min(
                        Di_1[j] + 1,
                        Di[j - 1] + 1,
                        Di_1[j - 1] + cost
                );
            }
        }
        //System.out.print(Di[Di.length - 1]);
        return Di[Di.length - 1];
    }
    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}

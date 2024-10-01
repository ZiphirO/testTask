package com.example.testTask.service.impl;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.Settings;
import com.example.testTask.entities.StopFactor;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.StopFactorCalculator;
import com.example.testTask.service.StopFactorService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class StopFactorCalculatorImpl implements StopFactorCalculator {

    @Autowired
    private StopFactorService stopFactorService;

    @Override
    public boolean calculateStopFactor(RegPerson regPerson, VerifiedName verifiedName, Settings settings){
        Double distanceRatioThreshold = settings.getDistanceRatioThreshold();
        List<String> regPersonCombinations = getCombinations(regPerson.getFirstName(), regPerson.getLastName(), regPerson.getMiddleName());
        List<String> verifiedNameCombinations = getCombinations(verifiedName.getFirstName(), verifiedName.getOtherName(), verifiedName.getSurname());

        int maxDistance = 0;
        for (String regPersonCombination : regPersonCombinations) {
            for (String verifiedNameCombination : verifiedNameCombinations) {
                int distance = levenshteinDistance(regPersonCombination, verifiedNameCombination);
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }
        StopFactor stopFactor = new StopFactor();
        stopFactor.setPersonStopFactor(maxDistance < distanceRatioThreshold);
        stopFactor.setRegPerson(regPerson);
        stopFactorService.initStopFactor(stopFactor);
        return maxDistance < distanceRatioThreshold;
    }

    @Override
    public List<String> getCombinations(String firstName, String lastName, String middleName) {
        List<String> combinations = new ArrayList<>();
        combinations.add(firstName + lastName);
        combinations.add(firstName + middleName);
        combinations.add(lastName + middleName);
        return combinations;
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }

    @Override
    public int levenshteinDistance(String str1, String str2) {
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
        return Di[Di.length - 1];
    }
}

package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.SettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StopFactorCalculator {

    private final SettingsRepository SETTINGS_REPOSITORY;

    public boolean calculateStopFactor(RegPerson regPerson, VerifiedName verifiedName){
        Double distanceRatioThreshold = SETTINGS_REPOSITORY.findAll().get(0).getDistanceRatioThreshold();
        List<String> regPersonCombinations = getCombinations(regPerson.getFirstName(), regPerson.getLastName(), regPerson.getMiddleName());
        List<String> verifiedNameCombinations = getCombinations(verifiedName.getFirstName(), verifiedName.getLastName(), verifiedName.getMiddleName());

        int maxDistance = 0;
        for (String regPersonCombination : regPersonCombinations) {
            for (String verifiedNameCombination : verifiedNameCombinations) {
                int distance = levenshteinDistance(regPersonCombination, verifiedNameCombination);
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }

        return maxDistance < distanceRatioThreshold;
    }

    private List<String> getCombinations(String firstName, String lastName, String middleName) {
        List<String> combinations = new ArrayList<>();
        combinations.add(firstName + lastName);
        combinations.add(firstName + middleName);
        combinations.add(lastName + middleName);
        return combinations;
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
    private int levenshteinDistance(String str1, String str2) {
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

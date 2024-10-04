package com.example.testTask.config;

import com.example.testTask.entities.*;
import com.example.testTask.service.*;
import com.example.testTask.service.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class TestTaskConfig {

    @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    @Bean
    CommandLineRunner commandLineRunner (RegPersonParser regPersonParser, VerifiedNameParser verifiedNameParser,
                                            CreditBureauParser creditBureauParser, RequestContentService requestContentService,
                                            SettingsService settingsService, RegPersonService regPersonService,
                                            VerifiedNameService verifiedNameService, StopFactorCalculator stopFactorCalculator){
        return (args) -> {
            List<RequestContent> contentList = requestContentService.fetchPersonsInfoLocal();
            for (RequestContent content : contentList){
                RegPerson regPerson = regPersonParser.regPersonParse(content);
                verifiedNameParser.verifiedNameParse(content, regPerson);
                creditBureauParser.creditBureauParse(content, regPerson);
            }

            Settings settings = settingsService.initSettings(Settings.builder().distanceRatioThreshold(0.9).build());
            for (RegPerson regPerson : regPersonService.getAllRegPersons()){
                for (VerifiedName verifiedName : verifiedNameService.getAllVerifiedNames()){
                    stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, settings);
                }
            }
        };
    }
}

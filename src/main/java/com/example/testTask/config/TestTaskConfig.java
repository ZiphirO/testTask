package com.example.testTask.config;

import com.example.testTask.entities.*;
import com.example.testTask.service.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
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

    @Bean(name = "cLR1")
    CommandLineRunner commandLineRunner2(RequestParserImpl requestParser, RequestContentServiceImpl requestContentService,
                                         CreditBureauServiceImpl creditBureauService){
        return (args) -> {
            List<RequestContent> contentList = requestContentService.fetchPersonsInfo();
            List<CreditBureau> creditBureauList = creditBureauService.fetchCreditBureaus();
            for (RequestContent content : contentList){
                requestParser.parseRequest(content);
            }
        };
    }
    @Bean(name = "cLR2")
    CommandLineRunner commandLineRunner3(RegPersonServiceImpl regPersonService, VerifiedNameServiceImpl verifiedNameService,
                                         StopFactorCalculatorImpl stopFactorCalculator, SettingsServiceImpl settingsService){
        return (args) -> {
           Settings settings = settingsService.initSettings(Settings.builder().distanceRatioThreshold(0.9).build());
            for (RegPerson regPerson : regPersonService.getAllRegPersons()){
                for (VerifiedName verifiedName : verifiedNameService.getAllVerifiedNames()){
                    stopFactorCalculator.calculateStopFactor(regPerson, verifiedName, settings);
                }
            }
        };
    }
}

package com.example.testTask.config;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    CommandLineRunner commandLineRunner1(RequestContentService requestContentService){
        return (args) -> {
            requestContentService.fetchPersonsInfo();
        };
    }
    @Bean(name = "cLR2")
    CommandLineRunner commandLineRunner2(RequestParser requestParser, RequestContentService requestContentService){
        return (args) -> {
            for (RequestContent content : requestContentService.fetchPersonsInfo()){
                requestParser.parseRequest(content);
            }
        };
    }
    @Bean(name = "cLR3")
    CommandLineRunner commandLineRunner3(RegPersonService regPersonService, VerifiedNameService verifiedNameService,
                                         StopFactorCalculator stopFactorCalculator){
        return (args) -> {
            for (RegPerson regPerson : regPersonService.getAllRegPersons()){
                for (VerifiedName verifiedName : verifiedNameService.getAllVerifiedNames()){
                    stopFactorCalculator.calculateStopFactor(regPerson, verifiedName);
                }
            }
        };
    }
}

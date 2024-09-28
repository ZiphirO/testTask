package com.example.testTask.config;

import com.example.testTask.entities.RequestContent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;

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


//    @Bean
//    CommandLineRunner commandLineRunner(RequestContentRepository requestContentRepository){
//        return (args) -> {
//            requestContentRepository.save(p1);
//            requestContentRepository.save(p2);
//            requestContentRepository.save(p1);
//
//
//        };
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(RequestContentRepository requestContentRepository,
//                                        RequestParser requestParser){
//        return (args) -> {
//            for (RequestContent content : requestContentRepository.findAll()){
//                requestParser.parseRequest(content);
//            }
//
//        };
//    }
}

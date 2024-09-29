package com.example.testTask.service;

import com.example.testTask.entities.RequestContent;
import com.example.testTask.repositories.RequestContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestContentService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final RequestContentRepository REQUEST_CONTENT_REPOSITORY;
    private final File PERSON_DIR = new File("src/main/resources/data/persons");
//    private final File person2 = new File("src/main/resources/data/persons/person2.json");
//    private final File person1 = new File("src/main/resources/data/persons/person1.json");
//    private final File person3 = new File("src/main/resources/data/persons/person3.json");

    public RequestContent createRequestContent(RequestContent requestContent){
            return REQUEST_CONTENT_REPOSITORY.save(requestContent);
    }

    public List<RequestContent> fetchPersonsInfo() throws IOException{
        File[] personList = PERSON_DIR.listFiles();
//        RequestContent p1 = new RequestContent(MAPPER.readTree(person1));
//        RequestContent p2 = new RequestContent(MAPPER.readTree(person2));
//        RequestContent p3 = new RequestContent(MAPPER.readTree(person3));
        List<RequestContent> pList = new ArrayList<>();
        assert personList != null;
        for (File file : personList){
            if (file.isFile()){
                RequestContent pers = new RequestContent(MAPPER.readTree(file));
                pList.add(pers);
            }
        }
        return REQUEST_CONTENT_REPOSITORY.saveAll(pList);
    }
}

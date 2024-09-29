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

    public RequestContent createRequestContent(RequestContent requestContent){
            return REQUEST_CONTENT_REPOSITORY.save(requestContent);
    }

    public List<RequestContent> fetchPersonsInfo() throws IOException{
        File[] personList = PERSON_DIR.listFiles();
        List<RequestContent> pList = new ArrayList<>();
        assert personList != null;
        for (File file : personList){
            if (file.isFile()){
                pList.add(new RequestContent(MAPPER.readTree(file)));
            }
        }
        return REQUEST_CONTENT_REPOSITORY.saveAll(pList);
    }
}

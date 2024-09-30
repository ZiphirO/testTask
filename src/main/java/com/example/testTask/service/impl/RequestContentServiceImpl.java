package com.example.testTask.service.impl;

import com.example.testTask.entities.RequestContent;
import com.example.testTask.repositories.RequestContentRepository;
import com.example.testTask.service.RequestContentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestContentServiceImpl implements RequestContentService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final RequestContentRepository requestContentRepository;
    private final File personDir = new File("src/main/resources/data/persons");

    @Override
    public RequestContent createRequestContent(RequestContent requestContent){
            return requestContentRepository.save(requestContent);
    }

    @Override
    public List<RequestContent> fetchPersonsInfo() throws IOException{
        File[] personList = personDir.listFiles();
        List<RequestContent> pList = new ArrayList<>();
        assert personList != null;
        for (File file : personList){
            if (file.isFile()){
                pList.add(new RequestContent(MAPPER.readTree(file)));
            }
        }
        return requestContentRepository.saveAll(pList);
    }
}

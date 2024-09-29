package com.example.testTask.service;

import com.example.testTask.entities.RequestContent;
import com.example.testTask.repositories.RequestContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestContentService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final RequestContentRepository requestContentRepository;

    private final File person2 = new File("src/main/resources/data/persons/person2.json");
    private final File person1 = new File("src/main/resources/data/persons/person1.json");
    private final File person3 = new File("src/main/resources/data/persons/person3.json");

    public RequestContent createRequestContent(RequestContent requestContent){
            return requestContentRepository.save(requestContent);
    }

    public List<RequestContent> fetchPersonsInfo() throws IOException{
        RequestContent p1 = new RequestContent(MAPPER.readTree(person1));
        RequestContent p2 = new RequestContent(MAPPER.readTree(person2));
        RequestContent p3 = new RequestContent(MAPPER.readTree(person3));
        List<RequestContent> pList = List.of(p1, p2, p3);
        return requestContentRepository.saveAll(pList);
    }
}

package com.example.testTask.service;

import com.example.testTask.entities.RequestContent;
import com.example.testTask.repositories.RequestContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class RequestContentService {
    @Autowired
    private RequestContentRepository requestContentRepository;

    private final File person2 = new File("src/main/java/com/example/testTask/persons/person2.json");

    private final File person1 = new File("src/main/java/com/example/testTask/persons/person1.json");

    private final File person3 = new File("src/main/java/com/example/testTask/persons/person3.json");

    private final ObjectMapper mapper = new ObjectMapper();
//
//            RequestContent p1 = mapper.readValue(person1, RequestContent.class);
//            RequestContent p2 = mapper.readValue(person2, RequestContent.class);
//            RequestContent p3 = mapper.readValue(person3, RequestContent.class);

    public RequestContentService() throws IOException {
    }


    public RequestContent createRequestContent(RequestContent requestContent){
            return requestContentRepository.save(requestContent);
    }

//    public List<RequestContent> fetchPersonsInfo(){
//        List<RequestContent> pList = List.of(p1, p2, p3);
//        return requestContentRepository.saveAll(pList);
//    }
}

package com.example.testTask.service.impl;

import com.example.testTask.entities.RequestContent;
import com.example.testTask.repositories.RequestContentRepository;
import com.example.testTask.service.RequestContentService;
import com.example.testTask.values.StrV;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestContentServiceImpl implements RequestContentService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final RequestContentRepository requestContentRepository;
    private final File personDir = new File(StrV.PERSON_DIR);

    @Override
    public RequestContent createRequestContent(RequestContent requestContent){
            return requestContentRepository.save(requestContent);
    }

    // реализация метода для работы в файловой системе контейнера в Docker
    @Override
    public List<RequestContent> fetchPersonsInfo() throws IOException{
        List<RequestContent> pList = new ArrayList<>();
        URL resource = getClass().getClassLoader().getResource("data/persons");

        if (resource != null) {
            File personDir = new File(resource.getFile());
            File[] personList = personDir.listFiles();

            assert personList != null;
            for (File file : personList) {
                if (file.isFile()) {
                    pList.add(new RequestContent(MAPPER.readTree(file)));
                }
            }
        }
        return requestContentRepository.saveAll(pList);
    }

    // реализация метода для работы в локальной файловой системе
    public List<RequestContent> fetchPersonsInfoLocal() throws IOException{
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

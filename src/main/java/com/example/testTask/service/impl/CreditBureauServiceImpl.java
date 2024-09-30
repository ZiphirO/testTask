package com.example.testTask.service.impl;

import com.example.testTask.entities.CreditBureau;
import com.example.testTask.repositories.CreditBureauRepository;
import com.example.testTask.service.CreditBureauService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditBureauServiceImpl implements CreditBureauService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final CreditBureauRepository CREDIT_BUREAU_REPOSITORY;
    private final File PERSON_DIR = new File("src/main/resources/data/persons");

    @Override
    public CreditBureau createCreditBureau(CreditBureau creditBureau){
        return CREDIT_BUREAU_REPOSITORY.save(creditBureau);
    }

    @Override
    public List<CreditBureau> fetchCreditBureaus() throws IOException {
        File[] personList = PERSON_DIR.listFiles();
        List<CreditBureau> creditBureauListList = new ArrayList<>();
        assert personList != null;
        for (File file : personList){
            if (file.isFile()){
                JsonNode requestContent = MAPPER.readTree(file);
                JsonNode creditBureau = requestContent.get("creditBureau");
//                MAPPER.writerWithDefaultPrettyPrinter()
//                        .writeValue(new File("src/main/resources/data/temporaryData/credit_bureau.json"),
//                                creditBureau);
                creditBureauListList.add(new CreditBureau(creditBureau));
            }
        }
        return CREDIT_BUREAU_REPOSITORY.saveAll(creditBureauListList);
    }
}

package com.example.testTask.service;

import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.VerifiedNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifiedNameService {

    @Autowired
    private VerifiedNameRepository verifiedNameRepository;

    public VerifiedName initVerifiedName(VerifiedName verifiedName){
        return verifiedNameRepository.save(verifiedName);
    }
}

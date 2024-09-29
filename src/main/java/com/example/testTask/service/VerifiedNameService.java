package com.example.testTask.service;

import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.VerifiedNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VerifiedNameService {

    private final VerifiedNameRepository VERIFIED_NAME_SERVICE;

    public VerifiedName initVerifiedName(VerifiedName verifiedName){
        return VERIFIED_NAME_SERVICE.save(verifiedName);
    }

    public List<VerifiedName> getAllVerifiedNames(){
        return VERIFIED_NAME_SERVICE.findAll();
    }
}

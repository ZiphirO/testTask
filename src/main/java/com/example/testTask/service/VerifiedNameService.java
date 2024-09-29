package com.example.testTask.service;

import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.VerifiedNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VerifiedNameService {

    private final VerifiedNameRepository verifiedNameRepository;

    public VerifiedName initVerifiedName(VerifiedName verifiedName){
        return verifiedNameRepository.save(verifiedName);
    }

    public List<VerifiedName> getAllVerifiedNames(){
        return verifiedNameRepository.findAll();
    }
}

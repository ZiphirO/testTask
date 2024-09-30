package com.example.testTask.service.impl;

import com.example.testTask.entities.VerifiedName;
import com.example.testTask.repositories.VerifiedNameRepository;
import com.example.testTask.service.VerifiedNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VerifiedNameServiceImpl implements VerifiedNameService {

    private final VerifiedNameRepository verifiedNameRepository;

    @Override
    public VerifiedName initVerifiedName(VerifiedName verifiedName){
        return verifiedNameRepository.save(verifiedName);
    }

    @Override
    public List<VerifiedName> getAllVerifiedNames(){
        return verifiedNameRepository.findAll();
    }
}

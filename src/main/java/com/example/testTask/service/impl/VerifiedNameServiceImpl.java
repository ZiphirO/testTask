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

    private final VerifiedNameRepository VERIFIED_NAME_SERVICE;

    @Override
    public VerifiedName initVerifiedName(VerifiedName verifiedName){
        return VERIFIED_NAME_SERVICE.save(verifiedName);
    }

    @Override
    public List<VerifiedName> getAllVerifiedNames(){
        return VERIFIED_NAME_SERVICE.findAll();
    }
}

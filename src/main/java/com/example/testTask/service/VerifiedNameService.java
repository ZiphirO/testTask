package com.example.testTask.service;

import com.example.testTask.entities.VerifiedName;

import java.util.List;

public interface VerifiedNameService {

    VerifiedName initVerifiedName(VerifiedName verifiedName);
    List<VerifiedName> getAllVerifiedNames();
    List<String> getVerifiedNameFields(VerifiedName verifiedName);
}

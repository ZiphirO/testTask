package com.example.testTask.service;

import com.example.testTask.entities.CreditBureau;

import java.io.IOException;
import java.util.List;

public interface CreditBureauService {

    List<CreditBureau> fetchCreditBureaus() throws IOException;
    CreditBureau createCreditBureau(CreditBureau creditBureau);
}

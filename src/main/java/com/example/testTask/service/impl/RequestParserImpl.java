package com.example.testTask.service.impl;

import com.example.testTask.entities.CreditBureau;
import com.example.testTask.entities.RegPerson;
import com.example.testTask.entities.RequestContent;
import com.example.testTask.entities.VerifiedName;
import com.example.testTask.service.CreditBureauService;
import com.example.testTask.service.RegPersonService;
import com.example.testTask.service.RequestParserService;
import com.example.testTask.service.VerifiedNameService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class RequestParserImpl implements RequestParserService {

    private final RegPersonService regPersonService;
    private final VerifiedNameService verifiedNameService;
    private final CreditBureauService creditBureauService;

    @Override
    public void parseRequest(RequestContent requestContent) throws NullPointerException {
        JsonNode content = requestContent.getContent();
        JsonNode regPersonNode = content.get("regPerson");
        JsonNode creditBureauNode = content.get("creditBureau");
        JsonNode verifiedNameNode = creditBureauNode.get("verified_name");
        JsonNode creditBureauInfoNode = content.get("creditBureau").get("account_info");
        RegPerson regPerson = new RegPerson();
        VerifiedName verifiedName = new VerifiedName();
        CreditBureau creditBureau = new CreditBureau();

        //parse regPerson
        if (regPersonNode.has("firstName")){
            regPerson.setFirstName(regPersonNode.get("firstName").asText());
        } else regPerson.setFirstName(null);
        if (regPersonNode.has("middleName")){
            regPerson.setMiddleName(regPersonNode.get("middleName").asText());
        } else  regPerson.setMiddleName(null);
        if (regPersonNode.has("lastName")){
            regPerson.setLastName(regPersonNode.get("lastName").asText());
        } else regPerson.setLastName(null);
        regPersonService.initRegPerson(regPerson);

        //parse verifiedName
        if (verifiedNameNode.has("first_name")){
            verifiedName.setFirstName(verifiedNameNode.get("first_name").asText());
        } else verifiedName.setFirstName(null);
        if (verifiedNameNode.has("other_name")){
            verifiedName.setOtherName(verifiedNameNode.get("other_name").asText());
        } else verifiedName.setOtherName(null);
        if (verifiedNameNode.has("surname")){
            verifiedName.setOtherName(verifiedNameNode.get("surname").asText());
        } else verifiedName.setOtherName(null);
        verifiedNameService.initVerifiedName(verifiedName);

        //parse creditBureau
        for (JsonNode accountNode : creditBureauInfoNode) {
            if (accountNode.has("account_number")){
                creditBureau.setAccountNumber(accountNode.get("account_number").asText());
            } else creditBureau.setAccountNumber(null);
            if (accountNode.has("account_status")){
                creditBureau.setAccountStatus(accountNode.get("account_status").asText());
            } else creditBureau.setAccountStatus(null);
            if (accountNode.has("current_balance")){
                creditBureau.setCurrentBalance(new BigDecimal(accountNode.get("current_balance").asText()));
            } else creditBureau.setCurrentBalance(null);
            if (accountNode.has("date_opened")){
                creditBureau.setDateOpened(accountNode.get("date_opened").asText());
            } else creditBureau.setDateOpened(null);
            if (accountNode.has("days_in_arrears")){
                creditBureau.setDaysInArrears(accountNode.get("days_in_arrears").asInt());
            } else creditBureau.setDaysInArrears(null);
            if (accountNode.has("delinquency_code")){
                creditBureau.setDelinquencyCode(accountNode.get("delinquency_code").asText());
            } else creditBureau.setDelinquencyCode(null);
            if (accountNode.has("highest_days_in_arrears")){
                creditBureau.setHighestDaysInArrears(accountNode.get("highest_days_in_arrears").asInt());
            } else creditBureau.setHighestDaysInArrears(null);
            if (accountNode.has("is_your_account")){
                creditBureau.setIsYourAccount(accountNode.get("is_your_account").asBoolean());
            }else creditBureau.setIsYourAccount(null);
            if (accountNode.has("last_payment_amount")){
                creditBureau.setLastPaymentAmount(new BigDecimal(accountNode.get("last_payment_amount").asText()));
            } else creditBureau.setLastPaymentAmount(null);
            if (accountNode.hasNonNull("last_payment_date")){
                creditBureau.setLastPaymentDate(accountNode.get("last_payment_date").asText());
            } else creditBureau.setLastPaymentDate(null);
            if (accountNode.has("loaded_at")){
                creditBureau.setLoadedAt(accountNode.get("loaded_at").asText());
            } else creditBureau.setLoadedAt(null);
            if (accountNode.has("original_amount")){
                creditBureau.setOriginalAmount(new BigDecimal(accountNode.get("original_amount").asText()));
            } else creditBureau.setOriginalAmount(null);
            if (accountNode.has("overdue_balance")){
                creditBureau.setOverdueBalance(new BigDecimal(accountNode.get("overdue_balance").asText()));
            } else creditBureau.setOverdueBalance(null);
            if (accountNode.hasNonNull("overdue_date")){
                creditBureau.setOverdueDate(accountNode.get("overdue_date").asText());
            } else creditBureau.setOverdueDate(null);
            if (accountNode.has("product_type_id")){
                creditBureau.setProductTypeId(accountNode.get("product_type_id").asInt());
            } else creditBureau.setProductTypeId(null);

            creditBureau.setRegPerson(regPerson);
            creditBureauService.initCreditBureau(creditBureau);
        }
    }
}

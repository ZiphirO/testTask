package com.example.testTask.repositories;

import com.example.testTask.entities.CreditBureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditBureauRepository extends JpaRepository<CreditBureau, Long> {

}

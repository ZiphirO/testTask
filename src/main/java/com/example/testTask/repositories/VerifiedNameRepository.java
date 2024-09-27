package com.example.testTask.repositories;

import com.example.testTask.entities.VerifiedName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifiedNameRepository extends JpaRepository<VerifiedName, Long> {

}

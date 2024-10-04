package com.example.testTask.repositories;

import com.example.testTask.entities.StopFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopFactorRepository extends JpaRepository<StopFactor, Long> {

}

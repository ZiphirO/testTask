package com.example.testTask.repositories;

import com.example.testTask.entities.RequestContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestContentRepository extends JpaRepository<RequestContent, Long> {

}

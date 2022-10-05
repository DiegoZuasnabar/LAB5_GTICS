package com.pucp.lab5gtics.repository;

import com.pucp.lab5gtics.entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Completar
@Repository
public interface JobRepository extends JpaRepository<JobsEntity,String> {
}

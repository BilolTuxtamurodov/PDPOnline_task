package com.company.PDPOnline.repository;

import com.company.PDPOnline.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Integer> {
}
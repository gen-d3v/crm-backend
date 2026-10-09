package com.crmnexus.backend.repository;

import com.crmnexus.backend.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

}

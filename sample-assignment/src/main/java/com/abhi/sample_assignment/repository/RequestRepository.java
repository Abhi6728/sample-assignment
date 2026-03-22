package com.abhi.sample_assignment.repository;

import com.abhi.sample_assignment.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}

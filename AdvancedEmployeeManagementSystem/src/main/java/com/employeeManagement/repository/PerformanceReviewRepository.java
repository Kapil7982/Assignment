package com.employeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.PerformanceReview;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
    List<PerformanceReview> findByEmployee(Customer employee);
}

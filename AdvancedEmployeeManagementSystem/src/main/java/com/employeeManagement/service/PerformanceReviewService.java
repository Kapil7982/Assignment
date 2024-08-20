package com.employeeManagement.service;

import java.util.List;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.PerformanceReview;

public interface PerformanceReviewService {
    PerformanceReview createReview(PerformanceReview review);
    List<PerformanceReview> getReviewsByEmployee(Customer employee);
}

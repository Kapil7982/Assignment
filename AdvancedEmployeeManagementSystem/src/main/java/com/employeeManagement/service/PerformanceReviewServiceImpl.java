package com.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.PerformanceReview;
import com.employeeManagement.repository.PerformanceReviewRepository;

@Service
public class PerformanceReviewServiceImpl implements PerformanceReviewService {
    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

	@Override
	public PerformanceReview createReview(PerformanceReview review) {
		return performanceReviewRepository.save(review);
	}

	@Override
	public List<PerformanceReview> getReviewsByEmployee(Customer employee) {
		return performanceReviewRepository.findByEmployee(employee);
	}

}

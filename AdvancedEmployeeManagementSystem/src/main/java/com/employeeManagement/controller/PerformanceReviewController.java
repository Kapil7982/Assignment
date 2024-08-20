package com.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.PerformanceReview;
import com.employeeManagement.service.PerformanceReviewService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/reviews")
public class PerformanceReviewController {
    @Autowired
    private PerformanceReviewService performanceReviewService;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<PerformanceReview> createReview(@RequestBody PerformanceReview review) {
    	 PerformanceReview createdReview = performanceReviewService.createReview(review);
         return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}")
    @PreAuthorize("hasRole('MANAGER') or #employeeId == authentication.principal.id")
    public ResponseEntity<List<PerformanceReview>> getReviewsByEmployee(@PathVariable Long employeeId) {
    	 Customer employee = new Customer();
         employee.setCustId(employeeId.intValue());
         List<PerformanceReview> reviews = performanceReviewService.getReviewsByEmployee(employee);
         return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Other endpoints
}

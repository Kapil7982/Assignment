package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add custom query methods if needed
}


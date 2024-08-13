package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Add custom query methods if needed
}

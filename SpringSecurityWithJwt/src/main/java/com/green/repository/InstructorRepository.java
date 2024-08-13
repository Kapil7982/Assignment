package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Add custom query methods if needed
}


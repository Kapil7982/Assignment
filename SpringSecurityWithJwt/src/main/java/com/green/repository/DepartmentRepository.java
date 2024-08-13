
package com.green.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Add custom query methods if needed
}


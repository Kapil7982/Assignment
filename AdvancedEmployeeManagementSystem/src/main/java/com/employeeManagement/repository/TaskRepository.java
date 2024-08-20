package com.employeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedEmployee(Customer employee);
}

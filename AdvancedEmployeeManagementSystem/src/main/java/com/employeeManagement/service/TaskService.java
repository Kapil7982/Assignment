package com.employeeManagement.service;

import java.util.List;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.Task;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long taskId);
    List<Task> getTasksByEmployee(Customer employee);
}
package com.employeeManagement.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.PerformanceReview;
import com.employeeManagement.model.Task;
import com.employeeManagement.model.TaskStatus;
import com.employeeManagement.repository.CustomerRepository;
import com.employeeManagement.repository.PerformanceReviewRepository;
import com.employeeManagement.repository.TaskRepository;

@Service
public class ReportingService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

    public String generateEmployeePerformanceReport() {
    	StringBuilder csvReport = new StringBuilder();
        csvReport.append("Employee ID,Name,Average Rating,Completed Tasks\n");

        List<Customer> employees = customerRepository.findAll();
        for (Customer employee : employees) {
            double avgRating = performanceReviewRepository.findByEmployee(employee).stream()
                    .mapToInt(PerformanceReview::getRating)
                    .average()
                    .orElse(0.0);
            long completedTasks = taskRepository.findByAssignedEmployee(employee).stream()
                    .filter(task -> task.getStatus() == TaskStatus.COMPLETED)
                    .count();

            csvReport.append(String.format("%d,%s,%.2f,%d\n", 
                employee.getCustId(), employee.getName(), avgRating, completedTasks));
        }

        return csvReport.toString();

    }

    public String generateTaskStatusReport() {
    	StringBuilder csvReport = new StringBuilder();
        csvReport.append("Task ID,Title,Assigned Employee,Status,Due Date\n");

        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            csvReport.append(String.format("%d,%s,%s,%s,%s\n", 
                task.getId(), task.getTitle(), task.getAssignedEmployee().getName(), 
                task.getStatus(), task.getDueDate()));
        }

        return csvReport.toString();
    }

    public String generateDepartmentProductivityReport() {
    	StringBuilder csvReport = new StringBuilder();
        csvReport.append("Department,Total Employees,Completed Tasks,Average Rating\n");

        Map<String, List<Customer>> departmentEmployees = customerRepository.findAll().stream()
                .collect(Collectors.groupingBy(Customer::getAddress)); // Assuming address is used for department

        for (Map.Entry<String, List<Customer>> entry : departmentEmployees.entrySet()) {
            String department = entry.getKey();
            List<Customer> employees = entry.getValue();
            int totalEmployees = employees.size();
            long completedTasks = employees.stream()
                    .flatMap(e -> taskRepository.findByAssignedEmployee(e).stream())
                    .filter(task -> task.getStatus() == TaskStatus.COMPLETED)
                    .count();
            double avgRating = employees.stream()
                    .flatMap(e -> performanceReviewRepository.findByEmployee(e).stream())
                    .mapToInt(PerformanceReview::getRating)
                    .average()
                    .orElse(0.0);

            csvReport.append(String.format("%s,%d,%d,%.2f\n", 
                department, totalEmployees, completedTasks, avgRating));
        }

        return csvReport.toString();
    }
}
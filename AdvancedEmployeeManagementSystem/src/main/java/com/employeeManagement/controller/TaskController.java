package com.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.Task;
import com.employeeManagement.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
    	Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    @PreAuthorize("hasRole('MANAGER') or hasRole('EMPLOYEE')")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
    	task.setId(taskId);
        Task updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employee/{employeeId}")
    @PreAuthorize("hasRole('MANAGER') or #employeeId == authentication.principal.id")
    public ResponseEntity<List<Task>> getTasksByEmployee(@PathVariable Integer employeeId) {
        Customer employee = new Customer();
        employee.setCustId(employeeId);
        List<Task> tasks = taskService.getTasksByEmployee(employee);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}

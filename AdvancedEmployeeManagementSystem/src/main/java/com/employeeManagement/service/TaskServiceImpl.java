package com.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.model.Customer;
import com.employeeManagement.model.Task;
import com.employeeManagement.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

	@Override
	public Task createTask(Task task) {
		 return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		if (!taskRepository.existsById(task.getId())) {
            throw new RuntimeException("Task not found");
        }
        return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
		
	}

	@Override
	public List<Task> getTasksByEmployee(Customer employee) {
		return taskRepository.findByAssignedEmployee(employee);
	}

}

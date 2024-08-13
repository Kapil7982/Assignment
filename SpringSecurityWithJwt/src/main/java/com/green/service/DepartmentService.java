package com.green.service;

import java.util.List;

import com.green.model.Department;

public interface DepartmentService {

	public List<Department> getAllDepartments();
	public Department getDepartmentById(Long id);
	public Department saveDepartment(Department department);
	public void deleteDepartment(Long id);
}

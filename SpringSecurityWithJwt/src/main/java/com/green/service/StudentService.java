package com.green.service;

import java.util.List;

import com.green.model.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student getStudentById(Long id);
	public Student saveStudent(Student student);
	public void deleteStudent(Long id);
	
}

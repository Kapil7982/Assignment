package com.green.service;

import java.util.List;

import com.green.model.Instructor;

public interface InstructorService {

	public List<Instructor> getAllInstructors();
	public Instructor getInstructorById(Long id);
	public Instructor saveInstructor(Instructor instructor);
	public void deleteInstructor(Long id);
	 
}

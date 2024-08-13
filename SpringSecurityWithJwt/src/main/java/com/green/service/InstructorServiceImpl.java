package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.model.Instructor;
import com.green.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
    private InstructorRepository instructorRepository;
	
	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}

	@Override
	public Instructor getInstructorById(Long id) {
		return instructorRepository.findById(id).orElse(null);
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Override
	public void deleteInstructor(Long id) {
		instructorRepository.deleteById(id);
	}

}

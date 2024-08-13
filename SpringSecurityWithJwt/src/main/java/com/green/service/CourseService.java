package com.green.service;

import java.util.List;

import com.green.model.Course;

public interface CourseService {

	public List<Course> getAllCourses();
	public Course getCourseById(Long id);
	public Course saveCourse(Course course);
	 public void deleteCourse(Long id);
}

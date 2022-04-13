package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseRepository;
import com.app.pojos.Course;
import com.app.pojos.Student;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	private List<Student> students=new ArrayList<>();
	
	@Override
	public Course addCourse(Course course) {
		Course course1=courseRepo.save(course);
		students=course.getStudents();
		return course1;
	}

	@Override
	public String deleteCourse(String id) {
		courseRepo.deleteById(id);
		return "Course deleted successfully";
	}

}

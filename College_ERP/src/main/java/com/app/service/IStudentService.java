package com.app.service;

import java.util.List;

import com.app.pojos.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	Student addStudentDetails(Student transientStudent);
	String deleteStudent(String id);
	Student updateStudent(Student Student);
	Student getStudent(String id);
}

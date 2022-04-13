package com.app.service;

import java.util.List;

import com.app.pojos.Teacher;


public interface ITeacherService {
	List<Teacher> getAllTeachers();
	Teacher addTeacherDetails(Teacher teacher);
	String deleteTeacher(String id);
	Teacher updateTeacher(Teacher Teacher);
	Teacher getTeacher(String id);
}

package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.SubjectRepository;
import com.app.dao.TeacherRepository;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;

@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService {
	
	@Autowired
	private TeacherRepository teacherRepo;
	@Autowired
	private SubjectRepository subjectRepo;

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher addTeacherDetails(Teacher teacher) {
		// TODO Auto-generated method stub
		
		Teacher teacher1=teacherRepo.save(teacher);
		Subject subject=subjectRepo.getById(teacher.getSubject().getId());
		//Subject subject=subjectRepo.getById("Java");
		teacher1.setSubject(subject);
		return teacher1;
	}

	@Override
	public String deleteTeacher(String id) {
		Teacher teacher1=teacherRepo.getById(id);
		teacher1.setSubject(null);
		 teacherRepo.delete(teacher1);
		 return "Teacher with ID "+id+" deleted successfully";
	}

	@Override
	public Teacher updateTeacher(Teacher Teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher getTeacher(String id) {
		// TODO Auto-generated method stub
		System.out.println("in get teacher service method");
		return teacherRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher by ID " + id + " not found!!!!"));
	}
	
	

}

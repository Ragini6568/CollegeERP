package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseRepository;
import com.app.dao.SubjectRepository;
import com.app.pojos.Course;
import com.app.pojos.Subject;

@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	private SubjectRepository subjectRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectRepo.findAll();
	}

	@Override
	public Subject addSubject(Subject transientSubject) {
		// TODO Auto-generated method stub
		Subject subject1=subjectRepo.save(transientSubject);
		Course course=courseRepo.getById("1");
		course.addSubject(subject1);
		return subject1;
		
	}

	@Override
	public String deleteSubject(String id) {
		subjectRepo.deleteById(id);
		return "Subject with ID: "+id+" deleted successfully";
	}

}

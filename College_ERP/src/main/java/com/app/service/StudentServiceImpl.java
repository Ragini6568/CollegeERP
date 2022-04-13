package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.BatchRepository;
import com.app.dao.CourseRepository;
import com.app.dao.StudentRepository;
import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.Student;


@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private BatchRepository batchRepo;
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student addStudentDetails(Student student) {
		// TODO Auto-generated method stub
		Student student1=studentRepo.save(student);
		Course course=courseRepo.getById("1");
		Batch batch=batchRepo.getById(1);
		batch.addStudent(student1);
		course.addStudent(student1);
		
		return student1;
	}

	@Override
	public String deleteStudent(String id) {
		// TODO Auto-generated method stub
		Course course=courseRepo.getById("1");
		Batch batch=batchRepo.getById(1);
		course.removeStudent(studentRepo.getById(id));
		batch.removeStudent(studentRepo.getById(id));
		studentRepo.deleteById(id);
		return "Student with ID: "+id+" deleted successfully";
	}

	@Override
	public Student updateStudent(Student Student) {
		// TODO Auto-generated method stub
		return studentRepo.save(Student);
	}

	@Override
	public Student getStudent(String id) {
		// TODO Auto-generated method stub
		System.out.println("in student service get student method");
		return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student by ID " + id + " not found!!!!"));
		//return studentRepo.getById(id);
	}

}

package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AttendanceRepository;
import com.app.dao.MarkRepository;
import com.app.dao.StudentRepository;
import com.app.dao.SubjectRepository;
import com.app.pojos.Attendance;
import com.app.pojos.Mark;
import com.app.pojos.Student;
import com.app.pojos.Subject;

@Service
@Transactional
public class MarkServiceImpl implements IMarkService {
	
	@Autowired
	private MarkRepository markRepo;
	@Autowired 
	private StudentRepository studentRepo;
	@Autowired 
	private SubjectRepository subjectRepo;
	@Autowired
	private AttendanceRepository attRepo;

	@Override
	public Mark addMarkDetails(Mark mark) {
		
		Mark mark1=markRepo.save(mark);
		String str=mark.getStudent().getId();
		System.out.println(str);
		Student student=studentRepo.getById(str);
		mark1.setStudent(student);
		mark1.setSubject(subjectRepo.getById(mark.getSubject().getId()));
		//System.out.println(mark1.getSubject().getDuration());
		return mark1;
	}

	@Override
	public Attendance addAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		Attendance att1=attRepo.save(attendance);
		Student student=studentRepo.findById(attendance.getStudent().getId()).orElseThrow(() -> new ResourceNotFoundException("Student by ID not found!!!!"));
		att1.setStudent(student);
		Subject subject=subjectRepo.findById(attendance.getSubject().getId()).orElseThrow(() -> new ResourceNotFoundException("Subject by ID not found!!!!"));
		att1.setSubject(subject);
		System.out.println(subject.getDuration());
		return att1;
	}

}

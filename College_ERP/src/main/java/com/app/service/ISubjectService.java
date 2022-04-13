package com.app.service;

import java.util.List;

import com.app.pojos.Subject;

public interface ISubjectService {
	List<Subject> getAllSubjects();
	Subject addSubject(Subject transientSubject);
	String deleteSubject(String id);
}

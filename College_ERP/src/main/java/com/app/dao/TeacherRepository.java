package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
	
}

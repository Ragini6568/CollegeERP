package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="course_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
	//students
	//duration
	//subjects list
	//fees
	
	@Id
	private String id;
	
	private int duration;
	private double fees;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "course_id")
	private List<Student> students=new ArrayList<>();
	
	//later try changing list to tree
	//
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "course_id")
	private List<Subject> subjects=new ArrayList<>();
	
	public void addStudent(Student student) {
		System.out.println("student added in course");
		students.add(student);
	}
	
	public void removeStudent(Student student) {
		System.out.println("student removed from course");
		boolean flag=students.remove(student);
		if(flag)
			System.out.println("removed successfully");
		else
			System.out.println("not removed");
			
	}
	
	public void addSubject(Subject subject) {
		System.out.println("subject added in course");
		subjects.add(subject);
	}
	
	
}

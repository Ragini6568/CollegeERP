package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="batch_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Batch {

	@Id
	private int id;
	@Column(length=20)
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "batch_id")
	private List<Student> students=new ArrayList<>();

	public void addStudent(Student student) {
		System.out.println("student added in batch successfully");
		students.add(student);
	}
	
	public void removeStudent(Student student) {
		System.out.println("student removed from course");
		boolean flag=students.remove(student);
		if(flag)
			System.out.println("removed from batch successfully");
		else
			System.out.println("not removed from batch");
			
	}
}

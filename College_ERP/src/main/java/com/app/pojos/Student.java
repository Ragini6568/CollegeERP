package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="students_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student extends BaseEntity{
	
	//create student table
    //course will have one to many relationship with students
	@Column(length = 20)
	@Id
	private String id;

}

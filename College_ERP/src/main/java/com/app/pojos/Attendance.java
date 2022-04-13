package com.app.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="attendance_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attendance {
	
	@Id
	private Integer id;
	
	@OneToOne
	private Student student;
	@OneToOne
	private Subject subject;
	private int attendance;
}

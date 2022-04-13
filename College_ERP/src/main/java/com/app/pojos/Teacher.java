package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="teachers_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher extends BaseEntity{

	@Id
	private String id;
	
	@OneToOne
	private Subject subject;
	
}

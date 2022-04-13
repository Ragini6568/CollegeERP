package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="feedback_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Feedback {
	
	@Id
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	private Teacher teacher;
	
	private String feedback;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;
	
	
}

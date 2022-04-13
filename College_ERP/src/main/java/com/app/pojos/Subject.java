package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="subject_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject {
	@Id
	private String id;
	

	private int duration;

}

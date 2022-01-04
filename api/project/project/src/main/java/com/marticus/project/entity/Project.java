package com.marticus.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name="Proj_Name")
	String projName;
	
	@Column(name="Tech_Id")
	long techId;

}

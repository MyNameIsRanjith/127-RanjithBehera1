package com.marticus.department.entity;

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
@Table(name="department")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name="dept_code")
	String departmentCode;
	
	@Column(name="dept_name")
	String departmentName;
}

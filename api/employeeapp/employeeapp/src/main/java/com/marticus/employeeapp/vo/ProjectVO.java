package com.marticus.employeeapp.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProjectVO {
	
	private int id;
	private String projectName;
	private int techId;
	

}

package com.marticus.employeeapp.vo;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeVO {

	String empName;
	String empId;
	String projectName;
	String technology;
}

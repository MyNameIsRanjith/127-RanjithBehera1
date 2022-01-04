package com.marticus.employee.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marticus.employee.service.EmployeeService;
import com.marticus.employee.vo.EmployeeVO;


@Controller
@RequestMapping("/mvc-controller")
public class RestDataValue {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String getALl(Model model)
	{

		List<EmployeeVO> responseList = employeeService.getAllRestData();
		model.addAttribute("list", responseList);
		return "getEmpList.jsp";
	}
	
	
	
	
}


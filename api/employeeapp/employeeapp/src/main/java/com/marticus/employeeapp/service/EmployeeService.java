package com.marticus.employeeapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marticus.employeeapp.entity.EmployeeEntity;
import com.marticus.employeeapp.repository.EmployeeRepo;
import com.marticus.employeeapp.vo.EmployeeVO;
import com.marticus.employeeapp.vo.ProjectVO;
import com.marticus.employeeapp.vo.TechnologyVO;
 



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	RestTemplate template;
	
	@Autowired
	ProjectVO projectVO;
	
	@Autowired
	TechnologyVO technologyVO;
	
	
	


	public List<EmployeeEntity> getAll() {
		
		return employeeRepo.findAll();
	}

	public EmployeeEntity getEmpById(int id) {
		return employeeRepo.findEmployeeById(id);
		
	}

	public EmployeeEntity getEmpByEmpId(int empId) {
		return employeeRepo.findEmployeeByEmpId(empId);
	}

	public EmployeeEntity getEmpByProjectId(int id) {
		return employeeRepo.findEmployeeByProjectId(id);
	}

	public EmployeeEntity save(EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}

	public String getRestDataForSingleOne(int id) {
		EmployeeEntity employee = employeeRepo.findEmployeeById(id);
		String projectUrl= "http://PROJ-SERVICE/projects/"+employee.getProjectId();
		projectVO = template.getForObject(projectUrl, ProjectVO.class);
		if(projectVO != null)
		{
			String techUrl =  "http://TECH-SERVICE/tech/"+projectVO.getTechId();
			technologyVO = template.getForObject(techUrl, TechnologyVO.class);
		}
		String response = employee.getEmpId()+" | "+employee.getEmpName()+ " | "+projectVO.getProjectName()+" | "+technologyVO.getName();
		return response;
		
	}
	public List<EmployeeVO> getAllRestData() {
		List<EmployeeEntity> empList = employeeRepo.findAll();
		 
		List<EmployeeVO> empdata= new ArrayList<EmployeeVO>();
				
		for(EmployeeEntity employee : empList)
		{
			EmployeeVO emp=new EmployeeVO();
			emp.setEmpName(employee.getEmpName());
			emp.setEmpId(employee.getEmpId());
			
			String projectUrl= "http://localhost:9001/projects/"+employee.getProjectId();
			projectVO = template.getForObject(projectUrl, ProjectVO.class);
			if(projectVO != null)
			{
				String techUrl = "http://localhost:9002/tech/"+projectVO.getTechId();
				technologyVO = template.getForObject(techUrl, TechnologyVO.class);
			    emp.setProjectName(projectVO.getProjectName());
			    if(null!=technologyVO)
			    {
			    	emp.setTechnology(technologyVO.getName());
			    }
			}
			
			empdata.add(emp);
			
		}
		return empdata;
		
	}


}

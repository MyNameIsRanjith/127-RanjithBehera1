package com.marticus.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marticus.employee.entity.Employee;
import com.marticus.employee.repository.EmployeeRepository;
import com.marticus.employee.vo.EmployeeVO;
import com.marticus.employee.vo.ProjectVO;
import com.marticus.employee.vo.TechnologyVO;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProjectVO projectVO;
	
	@Autowired
	TechnologyVO technologyVO;

//	public Employee findEmployeeById(long id) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findEmployeeById(id);
//	}

//	public List<Employee> findAllEmployee() {
//		// TODO Auto-generated method stub
//		return employeeRepository.findAll();
//	}

	public Employee findEmployeeByEmpId(long empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeById(empId);
	}

	public List<EmployeeVO> getAllRestData() {
		// TODO Auto-generated method stub
		List<Employee> empList=employeeRepository.findAll();
		List<EmployeeVO> empData=new ArrayList<EmployeeVO>();
		for (Employee employee: empList)
		{
			EmployeeVO e1=new EmployeeVO();
			e1.setEmpName(employee.getEmpName());
			e1.setEmpId(employee.getEmpId());
			String projectUrl="http://PROJ-SERVICE/project/"+employee.getProjId();
			projectVO=restTemplate.getForObject(projectUrl, ProjectVO.class);
			if(projectVO!=null)
			{
				String technologyUrl="http://TECH-SERVICE/technology/"+projectVO.getTechId();
				technologyVO=restTemplate.getForObject(technologyUrl, TechnologyVO.class);
				e1.setProjName(projectVO.getProjName());
				if(technologyVO!=null)
				{
					e1.setTechName(technologyVO.getTechName());
				}
			}
			empData.add(e1);
		}		
		return empData;
	}

	public  EmployeeVO  getRestForEachId(long id) {
		// TODO Auto-generated method stub
		EmployeeVO empData=new EmployeeVO();
		Employee emp1=employeeRepository.findEmployeeById(id);
		empData.setEmpName(emp1.getEmpName());
		empData.setEmpId(emp1.getEmpId());
		String projectUrl="http://PROJ-SERVICE/project/"+emp1.getProjId();
		projectVO=restTemplate.getForObject(projectUrl, ProjectVO.class);
		if(projectVO!=null)
		{
			String technologyUrl="http://TECH-SERVICE/technology/"+projectVO.getTechId();
			technologyVO=restTemplate.getForObject(technologyUrl, TechnologyVO.class);
			empData.setProjName(projectVO.getProjName());
		}

		if(technologyVO!=null)
		{
			empData.setTechName(technologyVO.getTechName());
			
		}
		
	//	String response = emp1.getEmpId()+" | "+emp1.getEmpName()+ " | "+projectVO.getProjName()+" | "+technologyVO.getTechName();
		return empData;

	}

//	public Employee save(Employee employeeEntity) {
//		// TODO Auto-generated method stub
//			return employeeRepository.save(employeeEntity);
//		}

}

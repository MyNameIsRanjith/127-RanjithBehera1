package com.marticus.department.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.department.entity.DepartmentEntity;
import com.marticus.department.repo.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	public void saveCustomer(DepartmentEntity dept1) {
		// TODO Auto-generated method stub
		
		departmentRepository.save(dept1);
	}

	public DepartmentEntity findDepartmentById(long id) {
		// TODO Auto-generated method stub
		
		return departmentRepository.findDepartmentById(id);	
	}

	public List<DepartmentEntity> findAllDepartments() {
		// TODO Auto-generated method stub
		
		return departmentRepository.findAll();
	}

	public Boolean deleteDepartmentById(long id) {
		// TODO Auto-generated method stub
		
		DepartmentEntity dept2=departmentRepository.findDepartmentById(id);
		if(dept2!=null)
		{
			departmentRepository.delete(dept2);
			return true;
		}
		return false;
	}

	public void updateDepartment(DepartmentEntity deptupdate) {
		// TODO Auto-generated method stub
		
		DepartmentEntity deptNew=departmentRepository.findDepartmentById(deptupdate.getId());
		deptNew.setDepartmentCode(deptupdate.getDepartmentCode());
		deptNew.setDepartmentName(deptupdate.getDepartmentName());
		departmentRepository.save(deptNew);
	}

}

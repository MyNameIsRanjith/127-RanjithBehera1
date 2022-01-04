package com.marticus.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.project.entity.Project;
import com.marticus.project.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	public Project findProjectById(long id) {
		// TODO Auto-generated method stub
		return projectRepository.findProjectById(id);
	}

	public List<Project> findAllProject() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

}

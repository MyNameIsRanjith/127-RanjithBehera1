package com.marticus.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.project.entity.Project;
import com.marticus.project.service.ProjectService;



@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable long id)
	 {
		Project p2=projectService.findProjectById(id);
	     return ResponseEntity.ok(p2);
	 }
	
	@GetMapping("/")
	public ResponseEntity<List<Project>> getProjectList()
	 {
		List<Project> p3=projectService.findAllProject();
	     return ResponseEntity.ok(p3);
	 }

}

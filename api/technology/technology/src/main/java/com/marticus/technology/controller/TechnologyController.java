package com.marticus.technology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.technology.entity.Technology;
import com.marticus.technology.service.TechnologyService;


@RestController
@RequestMapping("/technology")
public class TechnologyController {
	@Autowired
	TechnologyService technologyService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Technology> getTechnologyById(@PathVariable long id)
	 {
		Technology t2=technologyService.findTechnologyById(id);
	     return ResponseEntity.ok(t2);
	 }
	
	@GetMapping("/")
	public ResponseEntity<List<Technology>> getTechnologyList()
	 {
		List<Technology> t3=technologyService.findAllTechnology();
	     return ResponseEntity.ok(t3);
	 }

}

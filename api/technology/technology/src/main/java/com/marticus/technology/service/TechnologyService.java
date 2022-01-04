package com.marticus.technology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.technology.entity.Technology;
import com.marticus.technology.repository.TechnologyRepository;

@Service
public class TechnologyService {

	
	@Autowired
	TechnologyRepository technologyRepository;

	public Technology findTechnologyById(long id) {
		// TODO Auto-generated method stub
		return technologyRepository.findTechnologyById(id);
	}

	public List<Technology> findAllTechnology() {
		// TODO Auto-generated method stub
		return technologyRepository.findAll();
	}

}

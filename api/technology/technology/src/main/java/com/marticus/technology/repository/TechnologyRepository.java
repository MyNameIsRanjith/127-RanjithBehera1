package com.marticus.technology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticus.technology.entity.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long>
{

	Technology findTechnologyById(long id);
	
	List<Technology> findAll();

}

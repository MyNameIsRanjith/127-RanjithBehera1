package com.marticus.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marticus.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findProjectById(long id);

	List<Project> findAll();

}

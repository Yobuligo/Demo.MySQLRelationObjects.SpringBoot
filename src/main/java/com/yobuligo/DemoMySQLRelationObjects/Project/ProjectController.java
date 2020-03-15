package com.yobuligo.DemoMySQLRelationObjects.Project;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yobuligo.DemoMySQLRelationObjects.Address.Address;
import com.yobuligo.DemoMySQLRelationObjects.Person.IPersonCrudRepository;
import com.yobuligo.DemoMySQLRelationObjects.Person.Person;

@RestController
public class ProjectController {

	@Autowired
	private IProjectCrudRepository projectCrudRepository;

	@PostMapping("/project")
	public Project addProject() {
		Address address = new Address();
		address.setNumber("20");
		address.setStreet("Dossenheimer Landstraße");

		Person person = new Person();
		person.setFirstname("Max");
		person.setLastname("Müller");
		person.setAddress(address);

		Project project = new Project();
		project.setDescription("My Project");
		project.setPersons(person);
		projectCrudRepository.save(project);
		return project;
	}

	@GetMapping("/project")
	public Iterable<Project> getProjects() {
		return projectCrudRepository.findAll();
	}

}

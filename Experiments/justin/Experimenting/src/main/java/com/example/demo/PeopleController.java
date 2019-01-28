package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@RequestMapping("/People")
	public List<People> getAllPeople() {
		return peopleService.getAllPeople();
	}
	@RequestMapping("/People/{SSN}")
	public People getPeople(@PathVariable String SSN) {
		return peopleService.getPeople(SSN);
		}
	
	
	
}

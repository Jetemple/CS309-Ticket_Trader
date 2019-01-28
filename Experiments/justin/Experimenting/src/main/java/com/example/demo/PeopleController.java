package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(method=RequestMethod.POST, value="/People")
	public void addPeople(@RequestBody People people) {
		PeopleService.addPeople(people);
	}
	@RequestMapping(method=RequestMethod.PUT, value="People/{name}")
	public void updatePeople(@RequestBody People people, @PathVariable String name) {
		PeopleService.updatePeople(name, people);
	}
	
	
}

package com.example.demo;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class peopleData {
	@Autowired
	private PeopleService peopleService;
	
	@RequestMapping("/People")
	public List<People> getAllPeople() {
		return peopleService.getAllPeople();

	}

}

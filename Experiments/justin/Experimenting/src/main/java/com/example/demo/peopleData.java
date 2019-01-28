package com.example.demo;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class peopleData {
	@RequestMapping("/People")
	public List<People> getAllPeople() {
		return Arrays.asList(
				new People("1234","JOE","06272000"),
				new People("4321","BOB","0000"),
				new People("9999","Hell","666666666")
				);

	}

}

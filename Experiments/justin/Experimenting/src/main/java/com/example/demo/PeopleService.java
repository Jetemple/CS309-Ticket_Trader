package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PeopleService {
	List<People> people = Arrays.asList(
			new People("1234", "JOE", "06272000"), 
			new People("4321", "BOB", "0000"),
			new People("9999", "Hell", "666666666")
			);

	public List<People> getAllPeople() {
		return people;
	}
	
	public People getPeople(String SSN) {
		return people.stream().filter(t -> t.getSSN().equals(SSN)).findFirst().get();
	}
}

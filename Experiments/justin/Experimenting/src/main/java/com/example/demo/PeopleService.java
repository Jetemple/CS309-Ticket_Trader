package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PeopleService {
	
	private static List<People> people = new ArrayList<>(Arrays.asList(
			new People("1234", "JOE", "06272000"), 
			new People("4321", "BOB", "0000"),
			new People("9999", "Hell", "666666666")
			));

	public List<People> getAllPeople() {
		return people;
	}
	
	public People getPeople(String SSN) {
		return people.stream().filter(t -> t.getSSN().equals(SSN)).findFirst().get();
	}

	public static void addPeople(People people2) {
		people.add(people2);
		
	}
	//Updates the persons name. Used a for loop to find the correct array to update.
	public static void updatePeople(String name, People people2) {
		for(int i=0; i<people.size(); i++) {
			People t= people.get(i);
			if(t.getName().equals(name)) {
				people.set(i, people2);
				return;
			}
		}
		
	}
}

package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportsController {
	@RequestMapping("/Sports")
	public List<People> getAllPeople() {
		return Arrays.asList(
				new People("fall","FootBall","Cyclone"),
				new People("winter","BasketBall","Dunks"),
				new People("Spring","BaseBall","LowBall")
				);

	}
}

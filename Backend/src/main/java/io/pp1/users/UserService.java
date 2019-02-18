package io.pp1.users;

import java.util.List;

import org.springframework.stereotype.Service;

public class UserService {

	private List<User> user;
	
	public UserService(List<User> user) {
		this.user = user;
		
	}
	
	public List<User> getUsers() {
		return user;
	}
}

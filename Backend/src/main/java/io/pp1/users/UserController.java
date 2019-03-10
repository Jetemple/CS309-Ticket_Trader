package io.pp1.users;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> getAll(){
		
		List<User> users = userRepository.findAll();
		return users;
	}
	

	@GetMapping("/users/{id}")
	public boolean userExist(@PathVariable Integer id) {
		
		
		return userRepository.existsById(id);
	}
	
	@PostMapping(value = "/users/login")
	public User userLogin(@RequestBody final User user) {
		
		String netid = user.getNet_Id();
		String temp = userRepository.getPassByNetID(netid);
		
		if((user.getPassword()).equals(temp)) {
			User OurUser = userRepository.getUserByPass(temp);
			OurUser.setPassword("true");
			return OurUser;
			
		}else {
			
			user.setPassword("false");
		}
		
		return user;
	}

	
	@PostMapping(value = "/users")
	public void post(@RequestBody final User users){
		userRepository.save(users);
	}

}

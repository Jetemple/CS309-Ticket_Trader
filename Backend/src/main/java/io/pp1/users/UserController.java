package io.pp1.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/users")
	public UserService getAll(){
		return new UserService(userRepository.findAll());
		
	}
	
	@PostMapping(value = "/users")
	public void persist(@RequestBody final User users){
		userRepository.save(users);

	}

}

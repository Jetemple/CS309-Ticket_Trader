package io.pp1.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/users")
	public List<User> getAll(){
		return (List<User>) userRepository.findAll();
		
	}
	
	@PostMapping(value = "/users")
	public List<User> persist(@RequestBody final User users){
		return (List<User>) userRepository.findAll();
		
	}

}

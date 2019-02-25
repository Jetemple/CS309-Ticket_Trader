package io.pp1.users;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======


import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> omar_branch1
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
<<<<<<< HEAD
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/users")
	public UserService getAll(){
		return new UserService(userRepository.findAll());
		
	}
	
	@PostMapping(value = "/users")
	public void persist(@RequestBody final User users){
		userRepository.save(users);

=======
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public List<User> getAll(){
		
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public boolean userExist(@PathVariable Integer id) {
		
		
		return userService.userExist(id);
	}
	
	@PostMapping(value = "/users")
	public void post(@RequestBody final User users){
		userService.post(users);
>>>>>>> omar_branch1
	}

}

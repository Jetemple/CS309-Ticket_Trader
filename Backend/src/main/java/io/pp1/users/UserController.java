package io.pp1.users;



import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	private UserService userService;

	
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public UserService getAll(){
		return new UserService(userRepository.findAll());
	}
	
	@GetMapping("/users/{id}")
	public boolean userExist(@PathVariable Integer id) {
		
		
		return userRepository.existsById(id);
	}
	
	@GetMapping(value = "/users/login")
	public boolean userLogin(@RequestBody final User user) {
		
		return userService.userLogin(user);
		
	}
	
	@PostMapping(value = "/users")
	public void post(@RequestBody final User users){
		userService.post(users);
	}

}

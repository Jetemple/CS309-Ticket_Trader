package io.pp1.users;

import java.util.List;
<<<<<<< HEAD

public class UserService {

	private List<User> user;
	
	public UserService(List<User> user) {
		this.user = user;
		
	}
	
	public List<User> getUsers() {
		return user;
=======
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}
	
	public boolean userExist(Integer id){
		
		return userRepository.existsById(id);
	}

	public void post(User user) {		
		userRepository.save(user);
>>>>>>> omar_branch1
	}
}

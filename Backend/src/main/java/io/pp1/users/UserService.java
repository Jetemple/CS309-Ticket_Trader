package io.pp1.users;

import java.util.List;
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
	}
	
	public boolean userLogin(User user) {
		
		String temp = userRepository.getPassByNetID(user.getNet_Id());
		
		if(user.getPassword().equals(temp))
			return true;
		
		return false;
	}
}

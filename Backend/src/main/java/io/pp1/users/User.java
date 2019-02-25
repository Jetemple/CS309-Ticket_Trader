package io.pp1.users;

import javax.persistence.Entity;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;
=======
import javax.persistence.Column;
>>>>>>> omar_branch1

@Entity
public class User {
	
	@Id
<<<<<<< HEAD
	@NotNull
	private Integer user_id;
	private String first_name;
	private String last_name;
=======
	private Integer user_id;

	private String password;
	private String first_name;
	private String last_name;
	private String net_id;
>>>>>>> omar_branch1
	
	public User() {
		
		
	}
	
<<<<<<< HEAD
	public User(Integer user_id, String first_name, String last_name) {
=======
	public User(Integer user_id, String first_name, String password, String last_name, String net_id){
>>>>>>> omar_branch1
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
<<<<<<< HEAD
=======
		this.password = password;
		this.net_id = net_id;
>>>>>>> omar_branch1
	}
	
	public Integer getUser_Id() {
		return user_id;
	}
	public void setUser_Id(Integer id) {
		this.user_id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
<<<<<<< HEAD
	
=======

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNet_Id() {
		return net_id;
	}

	public void setNet_Id(String netId) {
		this.net_id = netId;
	}

>>>>>>> omar_branch1
}

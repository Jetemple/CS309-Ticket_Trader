package io.pp1.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	@NotNull
	private Integer user_id;
	private String first_name;
	private String last_name;
	
	public User() {
		
		
	}
	
	public User(Integer user_id, String first_name, String last_name) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
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
	
}

package io.pp1.messages;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Message {
	
	@Id
	@NotNull
	private Integer message_id;
	
	private Integer user_1_id;
	private Integer user_2_id;
	private Integer ticket_id;
	private String message;
	
	
	public Message(@NotNull Integer message_id, Integer user_1_id, Integer user_2_id, Integer ticket_id,
			String message) {
		super();
		this.message_id = message_id;
		this.user_1_id = user_1_id;
		this.user_2_id = user_2_id;
		this.ticket_id = ticket_id;
		this.message = message;
	}

	public Message() {
		
	}

	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public Integer getUser_1_id() {
		return user_1_id;
	}
	public void setUser_1_id(Integer user_1_id) {
		this.user_1_id = user_1_id;
	}
	public Integer getUser_2_id() {
		return user_2_id;
	}
	public void setUser_2_id(Integer user_2_id) {
		this.user_2_id = user_2_id;
	}
	public Integer getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

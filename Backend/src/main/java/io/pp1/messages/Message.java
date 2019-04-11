package io.pp1.messages;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Message {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer message_id;
//	private Integer user_1_id;
	private String net_id;
//	private Integer user_2_id;
//	private Integer ticket_id;
	private String message;
//	private Date localTime;

	public Message(@NotNull Integer message_id, String net_id, String message) {
		super();
		this.message_id = message_id;
		this.net_id = net_id;
//		this.user_2_id = user_2_id;
//		this.ticket_id = ticket_id;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getNet_id() {
		return net_id;
	}

	public void setNet_id(String net_id) {
		this.net_id = net_id;
	}

//	public Integer getUser_1_id() {
//	return user_1_id;
//}
//
//public void setUser_1_id(Integer user_1_id) {
//	this.user_1_id = user_1_id;
//}
//	public Integer getUser_2_id() {
//	return user_2_id;
//}
//public void setUser_2_id(Integer user_2_id) {
//	this.user_2_id = user_2_id;
//}
//public Integer getTicket_id() {
//	return ticket_id;
//}
//public void setTicket_id(Integer ticket_id) {
//	this.ticket_id = ticket_id;
//}
	// public void setLocalTime(Date localTime) {
//		this.localTime = localTime;
//	}
//
//	public Date getLocalTime() {
//		return localTime;
//	}
//	

}

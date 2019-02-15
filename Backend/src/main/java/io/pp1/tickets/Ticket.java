package io.pp1.tickets;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {
	
	@Id
	@NotNull
	private String ticket_id;
	private Integer seller_id;
	private Integer price;
	private String game_date;
	private String sport;
	private String game_location;
	private Integer game_time;
	
	public Ticket() {
		
	}
	
	public Ticket(@NotNull String ticket_id, Integer seller_id, Integer price, 
			String game_date, String sport,String game_location, Integer game_time) {
		
		super();
		this.ticket_id = ticket_id;
		this.seller_id = seller_id;
		this.price = price;
		this.game_date = game_date;
		this.sport = sport;
		this.game_location = game_location;
		this.game_time = game_time;
	}

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getGame_date() {
		return game_date;
	}

	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getGame_location() {
		return game_location;
	}

	public void setGame_location(String game_location) {
		this.game_location = game_location;
	}

	public Integer getGame_time() {
		return game_time;
	}

	public void setGame_time(Integer game_time) {
		this.game_time = game_time;
	}
	
	
	
	
}

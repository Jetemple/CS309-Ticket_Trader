package io.pp1.tickets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {
	
	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer ticket_id;
	
	private String sport;
	private String game_location;
	private String game_date;
	private String game_time;
	private Integer price;
	private Integer seller_id;
	private String opponent;
	

	public Ticket() {
		
	}
	

	public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
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

	public String getGame_time() {
		return game_time;
	}

	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}


	public String getOpponent() {
		return opponent;
	}


	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	
	
	
	
}

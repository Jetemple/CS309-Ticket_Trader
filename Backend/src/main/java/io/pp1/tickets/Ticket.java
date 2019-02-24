package io.pp1.tickets;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {
	
	@Id
	@NotNull
	private Integer ticket_id;
	
	private String sport;
	private String game_location;
	private String game_date;
	private String game_time;
	private Integer price;
	private Integer seller_id;
	private String opponent;
	private String record;

	public Ticket() {	
	}
	
//	public Ticket(Integer ticket_id, String sport, String game_location, String game_date,  Integer game_time,Integer price, Integer seller_id) {
//	
//	this.ticket_id = ticket_id;
//	this.seller_id = seller_id;
//	this.price = price;
//	this.game_date = game_date;
//	this.sport = sport;
//	this.game_location = game_location;
//	this.game_time = game_time;
//}

	public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
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

	public String getGame_date() {
		return game_date;
	}

	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}

	public String getGame_time() {
		return game_time;
	}

	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}	
	
}

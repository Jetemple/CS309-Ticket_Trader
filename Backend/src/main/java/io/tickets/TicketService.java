package io.tickets;


import org.springframework.stereotype.Service;
import java.util.List;


public class TicketService {

	private List<Ticket> ticket;
	

	
	public TicketService(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	public List<Ticket> getUsers() {
		return ticket;
	}
}

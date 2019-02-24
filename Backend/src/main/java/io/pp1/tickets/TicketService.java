package io.pp1.tickets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class TicketService {
	
	private TicketRepository ticketRepository;
	
	private List<Ticket> ticket;
	
	
	public TicketService(List<Ticket> ticket) {
		this.ticket = ticket;
		
	}


	public List<Ticket> getTicket() {
		return ticket;
	}
	
	


}

package io.pp1.tickets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.pp1.tickets.Ticket;
import io.pp1.tickets.TicketRepository;

@RestController
public class TicketController {

	
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping(value = "/tickets")
	public List<Ticket> getAll(){
		return ticketRepository.findAll();	
	}
	
	@PostMapping(value = "/tickets")
	public void persist(@RequestBody final Ticket tickets){
		ticketRepository.save(tickets);
	}
	
//	@PutMapping(value = "/tickets/{ticket_id}")
//	public void update(@RequestBody Ticket ticket, @PathVariable String ticket_id) {
//		TicketRepository.updateTicket(ticket,ticket_id);
//	}
}

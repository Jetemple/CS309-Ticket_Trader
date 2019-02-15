package io.pp1.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TicketController {

	
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping(value = "/tickets")
	public TicketService getAll(){
		return new TicketService(ticketRepository.findAll());
		
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

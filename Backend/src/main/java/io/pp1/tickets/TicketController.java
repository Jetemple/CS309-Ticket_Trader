package io.pp1.tickets;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	
	@Autowired
	private TicketRepository ticketRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/tickets")
	public List<Ticket> getAll(){
		return ticketRepository.findAll();	
	}
	
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/{ticket_id}")
    public Ticket getTicket(@PathVariable Integer ticket_id) {
    	return (Ticket) ticketRepository.getTicketByID(ticket_id);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/sport/{sport}")
    public List<Ticket> getBySport(@PathVariable String sport) {
    	return ticketRepository.getTicketBySport(sport);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/date/{game_date}")
    public List<Ticket> getByDate(@PathVariable String game_date) {
    	return  ticketRepository.getTicketByDate(game_date);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/location/{game_location}")
    public List<Ticket> getByLocation(@PathVariable String game_location) {
    	return ticketRepository.getTicketByLocation(game_location);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/opponent/{opponent}")
    public List<Ticket> getByOpponent(@PathVariable String opponent) {
    	return ticketRepository.getTicketByOpponent(opponent);
    }
    
	@RequestMapping(method = RequestMethod.POST, path = "/tickets") //@PostMapping(value = "/tickets")
	public void persist(@RequestBody final Ticket ticket){
		ticketRepository.save(ticket);
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/tickets/{ticket_id}")
    public void delete(@PathVariable Integer ticket_id) {
    	ticketRepository.deleteById(ticket_id);
    }
    
}

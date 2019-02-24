package io.pp1.tickets;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	
	@Autowired
	private TicketRepository ticketRepository;
	//private TicketService ticketService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/tickets")
	public List<Ticket> getAll(){
		return ticketRepository.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tickets") //@PostMapping(value = "/tickets")
	public void persist(@RequestBody final Ticket ticket){
		ticketRepository.save(ticket);
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/{ticket_id}")
    public Ticket getTicket(@PathVariable Integer ticket_id) {
    	return (Ticket) ticketRepository.getTicketByID(ticket_id);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/getbydate/{game_date}")
    public List<Ticket> getByDate(@PathVariable String game_date) {
    	return  ticketRepository.getTicketByDate(game_date);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/tickets/{ticket_id}")
    public void delete(@PathVariable Integer ticket_id) {
    	ticketRepository.deleteById(ticket_id);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tickets/sport/{sport}")
    public List<Ticket> getBySport(@PathVariable String sport) {
    	return ticketRepository.getTicketBySport(sport);
    }
}

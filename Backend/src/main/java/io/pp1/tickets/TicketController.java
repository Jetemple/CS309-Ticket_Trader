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
	
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/ticket_id")
    public List<Ticket> getTicket(@RequestBody Ticket id) {
    	return ticketRepository.getTicketByID(id.getTicket_id());
    }
	
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/seller_id")
    public List<Ticket> getSellerTickets(@RequestBody Ticket seller_id) {
    	return ticketRepository.getTicketBySellerID(seller_id.getSeller_id());
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/sport")
    public List<Ticket> getBySport(@RequestBody Ticket sport) {
    	return ticketRepository.getTicketBySport(sport.getSport());
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/date")
    public List<Ticket> getByDate(@RequestBody Ticket game_date) {
    	return ticketRepository.getTicketByDate(game_date.getGame_date());
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/location")
    public List<Ticket> getByLocation(@RequestBody Ticket game_location) {
    	return ticketRepository.getTicketByLocation(game_location.getGame_location());
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/opponent")
    public List<Ticket> getByOpponent(@RequestBody Ticket opponent) {
    	return ticketRepository.getTicketByOpponent(opponent.getOpponent());
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/price")
    public List<Ticket> getByPrice(@RequestBody Ticket price) {
    	return ticketRepository.getTicketByPricet(price.getPrice());
    }
    
	@RequestMapping(method = RequestMethod.POST, path = "/tickets") //@PostMapping(value = "/tickets")
	public void persist(@RequestBody Ticket ticket){
		ticketRepository.save(ticket);
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/tickets/{ticket_id}")
    public void delete(@PathVariable Integer ticket_id) {
    	ticketRepository.deleteById(ticket_id);
    }
    
}

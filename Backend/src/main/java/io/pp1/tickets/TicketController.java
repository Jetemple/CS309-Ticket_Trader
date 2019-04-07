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
	public TicketService getAll(){
		return new TicketService(ticketRepository.findAll());	
	}
	
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/ticket_id")
    public TicketService getTicket(@RequestBody Ticket id) {
    	return new TicketService(ticketRepository.getTicketByID(id.getTicket_id()));
    }
    
  @RequestMapping(method = RequestMethod.POST, path = "/tickets/seller_id")
  public TicketService getSellerTickets(@RequestBody Ticket seller_id) {
  	return new TicketService(ticketRepository.getTicketBySellerID(seller_id.getSeller_id()));
  }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/sport")
    public TicketService getBySport(@RequestBody Ticket sport) {
    	return new TicketService(ticketRepository.getTicketBySport(sport.getSport()));
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/date")
    public TicketService getByDate(@RequestBody Ticket game_date) {
    	return  new TicketService(ticketRepository.getTicketByDate(game_date.getGame_date()));
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/location")
    public TicketService getByLocation(@RequestBody Ticket game_location) {
    	return new TicketService(ticketRepository.getTicketByLocation(game_location.getGame_location()));
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/tickets/opponent")
    public TicketService getByOpponent(@RequestBody Ticket opponent) {
    	return new TicketService(ticketRepository.getTicketByOpponent(opponent.getOpponent()));
    }
    
  @RequestMapping(method = RequestMethod.POST, path = "/tickets/price")
  public List<Ticket> getByPrice(@RequestBody Ticket price) {
  	return ticketRepository.getTicketByPricet(price.getPrice());
  }
    
	@RequestMapping(method = RequestMethod.POST, path = "/tickets") //@PostMapping(value = "/tickets")
	public void persist(@RequestBody final Ticket ticket){
		ticket.setLogoURL(ticketRepository.getIconURL(ticket.getOpponent()));
		ticketRepository.save(ticket);
	}
	
    @RequestMapping(method = RequestMethod.DELETE, path = "/tickets/{ticket_id}")
    public void delete(@PathVariable Integer ticket_id) {
    	ticketRepository.deleteById(ticket_id);
    }
    
}

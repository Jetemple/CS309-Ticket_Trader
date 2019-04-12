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
	public TicketService getAll() {
		return new TicketService(ticketRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.POST, path = "/tickets/filter")
	public TicketService getTicketsByFilter(@RequestBody Ticket filter) {
		if(filter.getGame_date()!=null && filter.getSport()!=null && filter.getOpponent()!=null) {
			return new TicketService(ticketRepository.filterTicketsByOpponentSportDate(filter.getOpponent(),filter.getSport(),filter.getGame_date()));
		}
		else if(filter.getGame_date()!=null && filter.getSport()!=null && filter.getOpponent()==null) {
			return new TicketService(ticketRepository.filterTicketsBySportDate(filter.getSport(),filter.getGame_date()));
		}
		else if(filter.getGame_date()!=null && filter.getSport()==null && filter.getOpponent()!=null) {
			return new TicketService(ticketRepository.filterTicketsByOpponentDate(filter.getOpponent(),filter.getGame_date()));
		}
		else if(filter.getGame_date()==null && filter.getSport()!=null && filter.getOpponent()!=null) {
			return new TicketService(ticketRepository.filterTicketsByOpponentSport(filter.getOpponent(),filter.getSport()));
		}
		else if(filter.getGame_date()!=null && filter.getSport()==null && filter.getOpponent()==null) {
			return new TicketService(ticketRepository.filterTicketsByDate(filter.getGame_date()));
		}
		else if(filter.getGame_date()==null && filter.getSport()!=null && filter.getOpponent()==null) {
			return new TicketService(ticketRepository.filterTicketsBySport(filter.getSport()));
		}
		else if(filter.getGame_date()==null && filter.getSport()==null && filter.getOpponent()!=null) {
			return new TicketService(ticketRepository.filterTicketsByOpponent(filter.getOpponent()));
		}
		else 
			return new TicketService(ticketRepository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/tickets/ticket_id")
	public TicketService getTicket(@RequestBody Ticket id) {
		return new TicketService(ticketRepository.getTicketByID(id.getTicket_id()));
	}


	@RequestMapping(method = RequestMethod.POST, path = "/tickets/net_id")
	public TicketService getSellerTickets(@RequestBody Ticket net_id) {
		return new TicketService(ticketRepository.getTicketBySellerID(net_id.getNet_id()));

	}

	@RequestMapping(method = RequestMethod.POST, path = "/tickets/location")
	public TicketService getByLocation(@RequestBody Ticket game_location) {
		return new TicketService(ticketRepository.getTicketByLocation(game_location.getGame_location()));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/tickets/price")
	public List<Ticket> getByPrice(@RequestBody Ticket price) {
		return ticketRepository.getTicketByPricet(price.getPrice());
	}

	@RequestMapping(method = RequestMethod.POST, path = "/tickets") // @PostMapping(value = "/tickets")
	public void persist(@RequestBody final Ticket ticket) {
		ticket.setLogoURL(ticketRepository.getIconURL(ticket.getOpponent()));
		ticketRepository.save(ticket);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/tickets/{ticket_id}")
	public void delete(@PathVariable Integer ticket_id) {
		ticketRepository.deleteById(ticket_id);
	}
	
}

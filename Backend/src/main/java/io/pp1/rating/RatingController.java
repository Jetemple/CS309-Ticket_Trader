package io.pp1.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.pp1.tickets.Ticket;
import io.pp1.tickets.TicketRepository;
import io.pp1.tickets.TicketService;

@RestController
public class RatingController {


		@Autowired
		private RatingRepository ratingRepository;
		
		
		@RequestMapping(method = RequestMethod.POST, path = "/rating/net_id")
		public RatingService getRating(@RequestBody Ticket net_id) {
			return new RatingService(ratingRepository.getRatingByID(net_id.getNet_id()));
		}
		
		@RequestMapping(method = RequestMethod.POST, path = "/rating")
		public RatingService getRating(@RequestBody Ticket net_id) {
			return new RatingService(ratingRepository.getRatingByID(net_id.getNet_id()));
		}
		
		
}

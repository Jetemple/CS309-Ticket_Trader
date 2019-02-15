package io.pp1.tickets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String>{

	List<Ticket> findall();

//	static void updateTicket(Ticket tickets, String ticket_id) {
//		for(int i=0;i<tickets.size();i++) {
//			
//		
//	}
}

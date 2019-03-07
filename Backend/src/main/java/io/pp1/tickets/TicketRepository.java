package io.pp1.tickets;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	public List<Ticket> findAll();
	
	@Query(value = "SELECT * FROM ticket u WHERE u.ticket_id = ?1", nativeQuery=true)
	Ticket getTicketByID(Integer ticket_id);
	
	@Query(value = "SELECT * FROM ticket u WHERE u.game_date = ?1", nativeQuery=true)
	List<Ticket> getTicketByDate(String game_date);

//	@Query(value = "DELETE FROM ticket u WHERE  u.ticket_id = ?1", nativeQuery=true)
//	List<Ticket> removeByID(Integer ticket_id);

}

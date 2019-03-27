package io.pp1.messages;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.pp1.tickets.Ticket;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	public List<Message> findAll();

	@Query(value = "SELECT * FROM message u WHERE u.ticket_id = ?1 and u.user_1_id = ?2 and u.user_2_id = ?3", nativeQuery=true)
	List<Message> getMessage(Integer ticket_id, Integer user_1_id, Integer user_2_id);
}

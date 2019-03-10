package io.pp1.logos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.pp1.tickets.Ticket;


@Repository
public interface LogoRepository extends JpaRepository<Logo, Integer> {
	
	@Query(value = "SELECT * FROM logo u WHERE u.img_name = ?1", nativeQuery=true)
	Logo getUrlFromOpponent(String opponent);

}

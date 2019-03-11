package io.pp1.logos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.pp1.tickets.Ticket;

public class LogoService {
	
	private LogoRepository logoRepository;
	
	private List<Logo> logo;
	
	
	public LogoService(List<Logo> logo) {
		this.logo= logo;
		
	}
	
	public List<Logo> getLogo() {
		return logo;
	}
	

}

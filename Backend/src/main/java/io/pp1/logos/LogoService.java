package io.pp1.logos;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LogoService {

	private LogoRepository logoRepository;
	
	public LogoService(LogoRepository logoRepository) {
		this.logoRepository = logoRepository;
	}
	
	public List<Logo> getLogos(){
		List<Logo> logos = (List<Logo>) logoRepository.findAll();
		return logos;
	}
	
}

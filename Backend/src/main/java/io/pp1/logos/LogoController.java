package io.pp1.logos;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoController {
	
	@Autowired
	private LogoRepository logoRepository;
	
	@GetMapping(value = "/logos")
	public LogoService getAll(){
		
		return new LogoService(logoRepository.findAll());

	}
	
	
	@GetMapping(value = "/logos/{opponent}")
	public Logo getUrl(@PathVariable String opponent) {
		
		return logoRepository.getUrlFromOpponent(opponent);
	}

}

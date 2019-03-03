package io.pp1.logos;


import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoController {
	
	@Autowired
	private LogoService logoService;
	
	@GetMapping(value = "/logos")
	public List<Logo> getAll(){
		
		return null;
	}
	
	@GetMapping(value= "/logos/{pic}")
	public String getUrl(@RequestBody final String logo) {
		
		return null;
		
	}
	

}

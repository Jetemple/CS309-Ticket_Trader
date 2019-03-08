package io.pp1.logos;


import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoController {
	
	@Autowired
	private LogoRepository logoRepository;
	
	@GetMapping(value = "/logos")
	public List<Logo> getAll(){
		
		return logoRepository.findAll();
	}

}

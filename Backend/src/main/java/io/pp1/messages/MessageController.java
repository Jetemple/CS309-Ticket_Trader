package io.pp1.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/message")
	public MessageService getAll() {
		return new MessageService(messageRepository.findAll());
	}

	@RequestMapping(method = RequestMethod.POST, path = "/message")
	public void addMessage(@RequestBody Message message) {
		messageRepository.save(message);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/message/{message_id}")
	public void delete(@PathVariable Integer message_id) {
		messageRepository.deleteById(message_id);
	}
}

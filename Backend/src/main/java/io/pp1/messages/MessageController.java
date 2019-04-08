package io.pp1.messages;

import java.util.List;

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
	
//	@RequestMapping(method = RequestMethod.POST, path = "/message/get")
//	public MessageService getMessgaeById(@RequestBody Message message) {
//		return new MessageService(messageRepository.getMessageByID(message.getMessage_id()));
//	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/message/get")
	public Message getMessgaeById(@RequestBody Message message) {
		return messageRepository.getMessage(message.getTicket_id(),message.getUser_1_id(),message.getUser_2_id());
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/message")
	public void delete(@RequestBody Message message) {
		messageRepository.deleteById(message.getMessage_id());
	}
}

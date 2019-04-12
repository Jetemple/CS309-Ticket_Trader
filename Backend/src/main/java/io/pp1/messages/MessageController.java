package io.pp1.messages;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/message")
	public MessageService getAll() {
		return new MessageService(messageRepository.findAll());
	}

	
	//sends message to database
	@RequestMapping(method = RequestMethod.POST, path = "/message")
	public void addMessage(@RequestBody Message message) {
		messageRepository.save(message);
	}

	
//	@RequestMapping(method = RequestMethod.POST, path = "/message/get")
//	public Message getMessgaeById(@RequestBody Message message) {
//		return messageRepository.getMessage(message.getTicket_id(),message.getUser_1_id(),message.getUser_2_id());
//	}
//	
	
	//make method to retrieve user1 and user2 id's so jack can know how to send stuff
//	@RequestMapping(method = RequestMethod.GET, path = "/message/getId1/{messageId}")
//	public Integer getUser1Id(@PathVariable Integer messageId) {
//		
//		
//		return messageRepository.getUser1Id(messageId);
//	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/message/getId2/{messageId}")
//	public Integer getUser2Id(@PathVariable Integer messageId) {
//		
//		
//		return messageRepository.getUser2Id(messageId);
//	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/message/{userId1}/{userId2}")
//	public Message[] getConvo(@PathVariable("userId1") Integer userId1, @PathVariable("userId2") Integer userId2) {
//		
//		return messageRepository.getConvo(userId1, userId2);
//	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/message/{net_id}")
//	public Message[] getConvo(@PathVariable String net_id) {
//		
//		return messageRepository.getConvo(net_id);
//	}
//	@RequestMapping(method = RequestMethod.GET, path = "/message/byId/{sender}/{receiver}")
//	public Message[] getConvoById(@PathVariable("sender") String sender, @PathVariable("receiver") String receiver) {
//		
//		return messageRepository.getConvoById(sender, receiver);
//	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/message/byId/{sender}")
//	public Message[] getConvoById(@PathVariable("sender") String sender) {
//		
//		return messageRepository.getConvoById(sender);
//	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/message/{sender}/{receiver}")
	public Message[] getConvo(@PathVariable("sender") String sender, @PathVariable("receiver") String receiver) {
		
		return messageRepository.getConvo(sender, receiver);
	}
	@RequestMapping(method = RequestMethod.DELETE, path = "/message")
	public void delete(@RequestBody Message message) {
		messageRepository.deleteById(message.getMessage_id());
	}
}

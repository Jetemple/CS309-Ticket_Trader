package io.pp1.messages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.pp1.messages.MessageRepository;

//this is the url front end should call in order to initialize the session.
@ServerEndpoint(value = "/websocket/{seller}/{buyer}/{ticket}", configurator = CustomConfigurator.class)
@Component
public class MessageSocketServer {
	// ASLDKJASL:KDJASKL:DJA:LKSJDLK:SJD;lska
	// Store all socket session and their corresponding username.
	private static Map<Session, String> sessionUsernameMap = new HashMap<>();
	private static Map<String, Session> usernameSessionMap = new HashMap<>();

	private final Logger logger = LoggerFactory.getLogger(MessageSocketServer.class);

	@Autowired
	private MessageRepository messageRepository;

	@OnOpen
	public void onOpen(Session session, @PathParam("seller") String seller, @PathParam("buyer") String buyer,
			@PathParam("ticket") String ticket) throws IOException {
		logger.info("Entered into Open");
		Integer ticketInt = Integer.valueOf(ticket);
		List<Message> messageList;
		String message = "";
		sessionUsernameMap.put(session, buyer);
		usernameSessionMap.put(buyer, session);

		if (buyer.equals(seller)) {
			if (messageRepository.getMessageByTicket_ID(ticket).size() != 0) {
				messageList = messageRepository.getMessageByTicket_ID(ticket);
				System.out.print("gets here");
				for (int i = 0; i < messageList.size(); i++) {
					Message toGoOver = messageList.get(i);
					message = message + toGoOver.getMessage() + "\n" + "Enter '#userName message' to send to user\n";
				}
			} else {
				usernameSessionMap.get(buyer).getBasicRemote().sendText("No messages for this ticket.");
			}
		} else {
			if (messageRepository.getMessageBySBT(seller, buyer, ticketInt) != null) {
				Message toUse = messageRepository.getMessageBySBT(seller, buyer, ticketInt);
				message = toUse.getMessage();
			} else {
				usernameSessionMap.get(buyer).getBasicRemote().sendText("Enter message to send to the Seller.\n");
			}
		}
		usernameSessionMap.get(buyer).getBasicRemote().sendText(message);
	}

	// what happens when socket receives a message
	@OnMessage
	public void onMessage(Session session, String message, @PathParam("seller") String seller,
			@PathParam("buyer") String buyer, @PathParam("ticket") String ticket) throws IOException {
		// Handle new messages
		logger.info("Entered into Message:: Got Message" + message);
		Integer ticketInt = Integer.valueOf(ticket);

		if (buyer.equals(seller) && message.charAt(0) == '#') {

			String destUsername = message.substring(1, message.indexOf(' '));
			message = message.substring(destUsername.length() + 2);
			System.out.print(destUsername + "    " + message);
			if (messageRepository.getMessageBySBT(seller, destUsername, ticketInt) != null) {

				if (usernameSessionMap.get(destUsername) != null) {
					usernameSessionMap.get(destUsername).getBasicRemote().sendText(message);
				}
				
				Message toUse = messageRepository.getMessageBySBT(seller, destUsername, ticketInt);
				message = toUse.getMessage() + "\n" + seller + ": " + message;
				toUse.setMessage(message);
				messageRepository.save(toUse);
			} else {
				usernameSessionMap.get(seller).getBasicRemote().sendText("Wrong contact name, try again.");
			}
		} else {
			if (messageRepository.getMessageBySBT(seller, buyer, ticketInt) != null) {
				// usernameSessionMap.get(buyer).getBasicRemote().sendText(buyer + ": " +
				// message);
				// usernameSessionMap.get(seller).getBasicRemote().sendText(buyer + ": " +
				// message);

				if (usernameSessionMap.get(seller) != null) {
					usernameSessionMap.get(seller).getBasicRemote().sendText(message);
				}

				Message toUse = messageRepository.getMessageBySBT(seller, buyer, ticketInt);
				message = toUse.getMessage() + "\n" + buyer + ": " + message;
				toUse.setMessage(message);
				messageRepository.save(toUse);

				// usernameSessionMap.get(seller).getBasicRemote().sendText(message);

				// usernameSessionMap.get(buyer).getBasicRemote().sendText(buyer + ": " +
				// message);
			} else {
				// usernameSessionMap.get(buyer).getBasicRemote().sendText(buyer + ": " +
				// message);
				// usernameSessionMap.get(seller).getBasicRemote().sendText(buyer + ": " +
				// message);

				if (usernameSessionMap.get(seller) != null) {
					usernameSessionMap.get(seller).getBasicRemote().sendText(message);
				}

				message = buyer + ": " + message;
				Message newMessage = new Message(0, seller, buyer, message, ticket);
				messageRepository.save(newMessage);

				// usernameSessionMap.get(buyer).getBasicRemote().sendText(buyer + ": " +
				// message);
			}
		}
	}

	// what happens when we close that session
	@OnClose
	public void onClose(Session session) throws IOException {
		logger.info("Entered into Close");

		String username = sessionUsernameMap.get(session);
		sessionUsernameMap.remove(session);
		usernameSessionMap.remove(username);
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		// Do error handling here
		logger.info("Entered into Error");
	}
}

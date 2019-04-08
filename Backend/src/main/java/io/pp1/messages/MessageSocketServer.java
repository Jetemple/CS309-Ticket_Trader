package io.pp1.messages;

import java.io.IOException;
import java.util.HashMap;
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

@ServerEndpoint(value="/websocket/{username}", configurator = CustomConfigurator.class)
@Component
public class MessageSocketServer {


	// Store all socket session and their corresponding username.
	private static Map<Session, String> sessionUsernameMap = new HashMap<>();
	private static Map<String, Session> usernameSessionMap = new HashMap<>();

	private final Logger logger = LoggerFactory.getLogger(MessageSocketServer.class);
	
	@Autowired
	private MessageRepository messageRepository;

	//private String use=messageRepository.getMessageOnly(11,3,4);
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) throws IOException {
		logger.info("Entered into Open");

		sessionUsernameMap.put(session, username);
		usernameSessionMap.put(username, session);

		String message = "User:" + username + " has Joined the Chat";
		broadcast(message);

//		sessionUsernameMap.put(session, username);
//		usernameSessionMap.put(username, session);
//		Integer sent=Integer.parseInt(username);
//		Integer to=Integer.parseInt(sendTo);
//		String loadMessage=messageRepository.getMessageOnly(sent,to);

	}

	@OnMessage
	public void onMessage(Session session, String message) throws IOException {
		// Handle new messages
		logger.info("Entered into Message: Got Message:" + message);
		String username = sessionUsernameMap.get(session);
		
//		usernameSessionMap.get(username).getBasicRemote().sendText(message);
//		usernameSessionMap.get(sendTo).getBasicRemote().sendText(message);
		broadcast(username + ": " + message);
	}

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

	private static void broadcast(String message) throws IOException {
		sessionUsernameMap.forEach((session, username) -> {
			synchronized (session) {
				try {
					session.getBasicRemote().sendText(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}

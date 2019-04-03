package io.pp1.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

//import org.apache.logging.log4j.message.Message;
import io.pp1.messages.Message;
import io.pp1.messages.MessageController;
import io.pp1.messages.MessageRepository;

@ServerEndpoint("/websocket/{sentID,sendToID,ticket_id}")
public class WebsocketConfig {
	
	@Autowired
	private MessageRepository messageRepository;
	
    private static Map<Session, String> sessionUsernameMap = new HashMap<>();
    private static Map<String, Session> usernameSessionMap = new HashMap<>();

	@OnOpen
	public void onOpen(Session session, @PathParam("sentID") String sentID, @PathParam("sendToID") String sendToID, @PathParam("ticket_id") String ticket_id) throws IOException {
		sessionUsernameMap.put(session, sentID);
		usernameSessionMap.put(sentID, session);
		String loadMessage=null;
		String message = null;
		Integer messageID=0;
		Integer sent=Integer.parseInt(sentID);
		Integer to=Integer.parseInt(sentID);
		Integer ticket = Integer.parseInt(sentID);
		//MessageController messages=new MessageController();
		Message toStore = new Message(messageID, sent, to, ticket, message);
		toStore=(Message) messageRepository.getMessage(ticket,sent,to);
		loadMessage=toStore.getMessage();
		String username = sessionUsernameMap.get(session);
		usernameSessionMap.get(username).getBasicRemote().sendText(loadMessage);
		usernameSessionMap.get(sendToID).getBasicRemote().sendText(loadMessage);
	}
	@OnMessage
	public void onMessage(Session session, String message, @PathParam("sentID") String sentID, @PathParam("sendToID") String sendToID, @PathParam("ticket_id") String ticket_id) throws IOException {
		String username = sessionUsernameMap.get(session);
		usernameSessionMap.get(username).getBasicRemote().sendText(message);
		usernameSessionMap.get(sendToID).getBasicRemote().sendText(message);
		//Handles saving the message to the database
		Integer messageID=0;
		Integer sent=Integer.parseInt(sentID);
		Integer to=Integer.parseInt(sentID);
		Integer ticket = Integer.parseInt(sentID);
		Message toStore = new Message(messageID, sent, to, ticket, message);
		MessageController messages=new MessageController();
		messages.addMessage(toStore);
		}
	
	@OnClose
	public void onClose(Session session) throws IOException {

		String username = sessionUsernameMap.get(session);
		sessionUsernameMap.remove(session);
		usernameSessionMap.remove(username);
	}
	@OnError
	public void onError(Session session, Throwable throwable) {
	// Do error handling here
	}
}

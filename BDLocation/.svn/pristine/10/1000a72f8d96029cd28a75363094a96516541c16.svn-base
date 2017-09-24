package com.cnten.platform.websocket.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

public class SockedSession {
	private String sessionId;
	private WebSocketSession session;
	private String sessionType;       //客户：customer;  客服：cuservice
	private String oweTo;
	private Map<String,String> clients;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public WebSocketSession getSession() {
		return session;
	}
	public void setSession(WebSocketSession session) {
		this.session = session;
	}
	public String getOweTo() {
		return oweTo;
	}
	public void setOweTo(String oweTo) {
		this.oweTo = oweTo;
	}
	public Map<String, String> getClients() {
		if(clients == null)
			clients = new HashMap<String, String>();
		return clients;
	}
	
	public void addClient(String uid,String session){
		if(clients == null)
			clients = new HashMap<String, String>();
		clients.put(uid, session);
	}
	
	public void removeClient(Long uid){
		clients.remove(uid);
	}
	
	public int getClientsSize(){
		if(clients == null) return 0;
		return clients.size();
	}
	public String getSessionType() {
		return sessionType;
	}
	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}
	@Override
	public String toString() {
		return "SockedSession [sessionId=" + sessionId + ", session=" + session
				+ ", sessionType=" + sessionType + ", oweTo=" + oweTo
				+ ", clients=" + clients + "]";
	}
	
	
}

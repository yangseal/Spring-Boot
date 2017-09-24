package com.cnten.platform.websocket.entity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.WebSocketSession;

public class SessionManager {
	private static final Map<String, SockedSession> customerSession;
	private static final List<SockedSession> cuserviceSession;  //客服列表
	static {
		customerSession = new ConcurrentHashMap<>();
		cuserviceSession = new CopyOnWriteArrayList<SockedSession>();
	}
	
	public static List<SockedSession> getCuserviceSessionList(){
		return cuserviceSession;
	}
	
	public static Map<String, SockedSession> getCustomerSession(){
		return customerSession;
	}
	
	
	public static SockedSession getAvailableSession(){
		int size = cuserviceSession.size();
		if(size == 0) return null;
		if(size == 1) return cuserviceSession.get(0);
		SockedSession rltSession = null;
		if(size>1){
			int clientSize = cuserviceSession.get(0).getClientsSize();
			rltSession = cuserviceSession.get(0);
			for (SockedSession item : cuserviceSession) {
				if(item.getClientsSize() < clientSize){
					clientSize = item.getClientsSize();
					rltSession = item;
				}
			}
		}
		return rltSession;
	}
	
	public static void addCuserviceSession(SockedSession session){
		cuserviceSession.add(session);
	}
	
	public static SockedSession getCuserviceSession(String uid){
		for (SockedSession item : cuserviceSession) {
			if(uid.equals(item.getSessionId())){
				return item;
			}
		}
		
		return null;
	}
	
	public static boolean removeCusericeSession(String uid){
		for (SockedSession item : cuserviceSession) {
			if(item.getSessionId() == uid){
				cuserviceSession.remove(item);
			}
		}
		return true;
	}
	
	public static boolean addCustomerSession(String oweCuservice, String uid, WebSocketSession session){
		SockedSession availSession = getCuserviceSession(oweCuservice);
		if(availSession != null)
			availSession.addClient(uid, "1");
		SockedSession customer = new SockedSession();
		customer.setSessionId(uid);
		customer.setSessionType("customer");
		customer.setSession(session);
		customer.setOweTo(oweCuservice);
		customerSession.put(uid, customer);
		return true;
	}
	
	public static boolean removeCustomerSession(String uid){
		SockedSession ssession = customerSession.get(uid);
		if(ssession == null) return true;
		//移除 客服列表中的  对应客户 session 
		if(getCuserviceSession(ssession.getOweTo()) != null){
			Map<String, String> clients = getCuserviceSession(ssession.getOweTo()).getClients();
			if(clients != null)
				clients.remove(uid);
		}
		
		customerSession.remove(uid);
		return true;
	}
}

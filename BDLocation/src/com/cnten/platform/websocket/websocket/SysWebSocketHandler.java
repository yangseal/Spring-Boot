package com.cnten.platform.websocket.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cnten.platform.websocket.entity.ClientServiceUser;
import com.cnten.platform.websocket.entity.Message;
import com.cnten.platform.websocket.entity.SessionManager;
import com.cnten.platform.websocket.entity.SockedSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Socket处理器
 * 
 * @author Goofy
 * @Date 2015年6月11日 下午1:19:50
 */
@Component
public class SysWebSocketHandler implements WebSocketHandler {

	/**
	 * 建立连接后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		ClientServiceUser cuser = (ClientServiceUser) session.getAttributes().get("user");
		
		if(ClientServiceUser.CLIENT_SERVICE_USER_CUSTOMER.equals(cuser.getUserType())){
			SockedSession customer = new SockedSession();
			customer.setSessionId(cuser.getId());
			customer.setSessionType(ClientServiceUser.CLIENT_SERVICE_USER_CUSTOMER);
			customer.setSession(session);
			SessionManager.addCustomerSession(cuser.getSendTo(),cuser.getId(),session);
			cientConnectDefultMessage(cuser.getSendTo(),cuser.getId());  //链接成功后发送消息
		}
		
		if(ClientServiceUser.CLIENT_SERVICE_USER_CUSERVICE.equals(cuser.getUserType())){
			SockedSession cuservice = new SockedSession();
			cuservice.setSessionId(cuser.getId());
			cuservice.setSessionType(ClientServiceUser.CLIENT_SERVICE_USER_CUSERVICE);
			cuservice.setSession(session);
			SessionManager.addCuserviceSession(cuservice);
		}
		
		System.out.println("-----customer------:" + SessionManager.getCustomerSession().toString());
		System.out.println("-----cuservice------:" + SessionManager.getCuserviceSessionList().toString());
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
			if(message.getPayloadLength()==0 && "".equals(message.getPayload()))return;
			Message msg=new Gson().fromJson(message.getPayload().toString(),Message.class);
			msg.setDate(new Date());
			ClientServiceUser cuser = (ClientServiceUser) session.getAttributes().get("user");
			String userType =  cuser.getUserType();
			msg.setUserType(userType);
			System.out.println("-----发送的消息----:" + message.getPayload().toString());
			sendMessageToUser(userType, msg.getTo(), new TextMessage(new GsonBuilder().setDateFormat("HH:mm:ss").create().toJson(msg)));
	}

	/**
	 * 消息传输错误处理
	 */
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
	}

	/**
	 * 关闭连接后
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		ClientServiceUser cuser = (ClientServiceUser) session.getAttributes().get("user");
		System.out.println("Websocket:" + cuser.getId() + "已经关闭" + "  ;----sessionType--: " + cuser.getUserType());
		if (session.isOpen()) {
			session.close();
		}
		removeSession(cuser);
	}
	
	private void removeSession(ClientServiceUser cuser){
		String sessionType = cuser.getUserType();
		String uid = cuser.getId();
		if(ClientServiceUser.CLIENT_SERVICE_USER_CUSTOMER.equals(sessionType)){
			SessionManager.removeCustomerSession(uid);
		}else{
			SessionManager.removeCusericeSession(uid);
		}
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	
	/**
	 * 客户 连接成功, 后发送默认消息
	 */
	private void cientConnectDefultMessage(String from, String to){
		try {
			JsonObject json = new JsonObject();
			json.addProperty("from", from);
			json.addProperty("fromName", "客服系统");
			json.addProperty("to", to);
			json.addProperty("text", "我们的在线咨询服务受理时间：工作日9:00-18:00。非受理时间的咨询，请邮件至service@gasshow.com，告知您的疑问及需求，我们将给予回复。▓text");
			Message msg=new Gson().fromJson(json.toString(),Message.class);
			msg.setDate(new Date());
			msg.setUserType(ClientServiceUser.CLIENT_SERVICE_USER_CUSERVICE);
			sendMessageToUser(ClientServiceUser.CLIENT_SERVICE_USER_CUSERVICE, to, new TextMessage(new GsonBuilder().setDateFormat("HH:mm:ss").create().toJson(msg)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(String userType, String ToUid, TextMessage message)
			throws IOException {
		WebSocketSession session = null;
		if(ClientServiceUser.CLIENT_SERVICE_USER_CUSTOMER.equals(userType)){
			SockedSession sockedSession = SessionManager.getCuserviceSession(ToUid);
			if(sockedSession != null)
				session = (WebSocketSession) sockedSession.getSession();
		}else{
			if(SessionManager.getCustomerSession() != null){
				if ( SessionManager.getCustomerSession().size()>0 && ToUid.length()>0)
					session = (WebSocketSession) SessionManager.getCustomerSession().get(ToUid).getSession();
			}
				
		}
		
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}

}

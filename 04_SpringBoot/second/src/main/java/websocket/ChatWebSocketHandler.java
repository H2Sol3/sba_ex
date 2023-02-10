package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatWebSocketHandler implements WebSocketHandler{
	public List<WebSocketSession> list = new ArrayList();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		// 클라이언트 요청시 즉각 호출되는 메서드
		
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 크라이언트로부터 수신시 즉각 호출
		//session - 웹소켓 클라이언트 객체 1개
		//message - 웹소켓 클라이언트가 보낸 문자열 데이터 - nickname:xxx
		String msg = (String)message.getPayload();
			for(WebSocketSession s : list) {
				WebSocketMessage<String> sendmsg = new TextMessage(msg);
				s.sendMessage(sendmsg); 
			}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 클라이언트가 연결 해ㅔ제시
		list.remove(session);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}

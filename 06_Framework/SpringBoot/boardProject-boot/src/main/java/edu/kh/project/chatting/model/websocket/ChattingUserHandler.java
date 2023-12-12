package edu.kh.project.chatting.model.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.kh.project.chatting.model.service.ChattingService;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChattingUserHandler extends TextWebSocketHandler{

	private final ChattingService service;
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("유저 : " + message.getPayload());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Member member = objectMapper.readValue(message.getPayload(), Member.class);
		
		System.out.println(member);
		
		for(WebSocketSession s : sessions) {
			
		}
		
		
	}
}

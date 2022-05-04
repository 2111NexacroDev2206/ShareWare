package org.kh.shareware.alarm.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class AlarmHandler extends TextWebSocketHandler{
	// 로그인 중인 전체 유저
	List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	// 로그인 중인 개별 유저
	Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
}

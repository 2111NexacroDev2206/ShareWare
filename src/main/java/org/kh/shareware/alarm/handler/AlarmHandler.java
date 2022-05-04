package org.kh.shareware.alarm.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class AlarmHandler extends TextWebSocketHandler{
	List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
}

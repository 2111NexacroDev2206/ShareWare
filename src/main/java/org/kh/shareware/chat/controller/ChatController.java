package org.kh.shareware.chat.controller;

import org.kh.shareware.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService cService;
	
	@RequestMapping(value = "/chat/chatListView.sw")
	public String chatListView(Model model) {
		model.addAttribute("myCondition", "chat");
		return "chat/chatRoom";
	}
	
}

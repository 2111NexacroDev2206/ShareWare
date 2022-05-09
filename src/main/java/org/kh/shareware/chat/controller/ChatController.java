package org.kh.shareware.chat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;
import org.kh.shareware.chat.service.ChatService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService cService;
	
	// 채팅방 목록 조회
	@RequestMapping(value = "/chat/chatListView.sw")
	public String chatListView(Model model) {
		model.addAttribute("myCondition", "chat");
		return "chat/chatRoom";
	}
	
	// 채팅방 생성
	@ResponseBody
	@RequestMapping(value = "/chat/registerChatRoom.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String registerChatRoom(HttpServletRequest request
			, @RequestParam("chatMember") String[] chatMember) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		int result = 0; // 채팅방 생성 결과 변수 선언
		ChatRoom chatRoom = new ChatRoom();
		if(chatMember.length == 1) { // 1:1 채팅
			chatRoom.setChatType(0);
		}else { // 1:N 채팅
			chatRoom.setChatType(1);
		}
		String chatTitle = member.getMemberName(); // 채팅방 제목(생성자 이름)
		chatRoom.setChatTitle(chatTitle);
		result = cService.registerChatRoom(chatRoom);
		if(result > 0) {
			int mResult = cService.registerChatMember(member.getMemberNum()); // 채팅방 생성자 등록
			for(int i = 0; i < chatMember.length; i++) {
				mResult = cService.registerChatMember(chatMember[i]); // 채팅방 사용자 등록
			}
			if(mResult > 0) {
				List<ChatMember> mList = cService.printAllMember();
				if(!mList.isEmpty()) {
					String[] chatMemberArr = new String[mList.size()]; // 채팅방 사용자 목록을 담을 배열 선언
					for(int j = 0; j < mList.size(); j++) {
						chatMemberArr[j] = mList.get(j).getDivName() + " " + mList.get(j).getMemName() + " " + mList.get(j).getRankName();
					}
					chatTitle = String.join(", ", chatMemberArr); // ', '를 구분자로 사용자 목록 배열을 하나의 문자열로 바꿔서 채팅방 제목 변수에 넣기
					cService.modifyChatTitle(chatTitle); // 채팅방 제목 바꾸기
				}
				return new Gson().toJson("채팅방 사용자 초대 성공");
			}else {
				return new Gson().toJson("채팅방 사용자 초대 실패");
			}
		}else {
			return new Gson().toJson("채팅방 생성 실패");
		}
	}
}

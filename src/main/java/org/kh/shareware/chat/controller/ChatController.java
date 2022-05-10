package org.kh.shareware.chat.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.chat.domain.ChatContent;
import org.kh.shareware.chat.domain.ChatMember;
import org.kh.shareware.chat.domain.ChatRoom;
import org.kh.shareware.chat.service.ChatService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class ChatController {
	
	@Autowired
	private ChatService cService;
	
	// 채팅방 목록 조회
	@RequestMapping(value = "/chat/chatListView.sw")
	public String chatListView(Model model, HttpServletRequest request) {
		model.addAttribute("myCondition", "chat");
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		List<ChatRoom> rList = cService.printAllChatRoom(member.getMemberNum());
		if(!rList.isEmpty()) {
			for(int i = 0; i < rList.size(); i++) {
				ChatContent chatContent = cService.printChatContent(rList.get(i).getChatRoomNo()); // 마지막 대화 내용과 날짜 가져오기
				rList.get(i).setChatContent(chatContent.getChatContent()); // 마지막 대화 내용 넣어주기
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd a K:mm"); // 2022-05-10 오후 5:30
				rList.get(i).setChatDate(sf.format(chatContent.getChatDate())); // 마지막 대화 날짜 넣어주기
			}
		}
		model.addAttribute("rList", rList);
		return "chat/chatRoom";
	}
	
	// 채팅방 생성
	@ResponseBody
	@RequestMapping(value = "/chat/registerChatRoom.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String registerChatRoom(HttpServletRequest request
			, @RequestParam("chatMember") String[] chatMember
			, @RequestParam("chatRoomTitle") String chatRoomTitle) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		int result = 0; // 채팅방 생성 결과 변수 선언
		ChatRoom chatRoom = new ChatRoom();
		if(chatMember.length == 1) { // 1:1 채팅
			chatRoom.setChatRoomType(0);
		}else { // 1:N 채팅
			chatRoom.setChatRoomType(1);
		}
		chatRoom.setChatRoomTitle(chatRoomTitle); // 채팅방 제목
		result = cService.registerChatRoom(chatRoom);
		if(result > 0) { // 채팅방 생성 성공 시
			int mResult = cService.registerChatMember(member.getMemberNum()); // 채팅방 생성자 등록
			for(int i = 0; i < chatMember.length; i++) {
				mResult = cService.registerChatMember(chatMember[i]); // 채팅방 사용자 등록
			}
			if(mResult > 0) { // 채팅방 생성자 등록 성공 시
				List<ChatMember> mList = cService.printAllMember(); // 채팅방 사용자 목록 조회
				String[] chatMemberArr = new String[mList.size()]; // 채팅방 사용자 목록을 담을 배열 선언
				if(!mList.isEmpty()) {
					for(int j = 0; j < mList.size(); j++) {
						chatMemberArr[j] = mList.get(j).getDivName() + " " + mList.get(j).getMemName() + " " + mList.get(j).getRankName();
					}
				}
				ChatContent chatContent = new ChatContent();
				// 채팅방 생성 날짜 공지 등록
				chatContent.setChatType(1); // 공지
				Date nowTime = new Date(); // 현재 날짜 가져오기
				SimpleDateFormat sf = new SimpleDateFormat("yyyy년 M월 d일 E요일");
				chatContent.setChatContent("- " + sf.format(nowTime) + " -"); // 채팅방 생성 날짜
				cService.registerChatContent(chatContent); // 채팅 등록(채팅방 생성 날짜 공지)
				// 채팅방 사용자 초대 공지 등록
				int n = chatMemberArr.length - 1; // 사용자 목록에서 생성자를 제외한 수
				String[] inviteMemberArr = new String[n]; // 초대한 사용자를 넣을 배열
				System.arraycopy(chatMemberArr, 1, inviteMemberArr, 0, n); // 첫 번째 항목(생성자)를 제외한 사용자 새로운 배열에 복사해서 넣기
				String inviteMember = ""; // 초대한 사용자 문자열 변수 선언
				for(int k = 0; k < inviteMemberArr.length; k++) {
					if(k < inviteMemberArr.length - 1) { // 마지막 사용자 전 사용자일 경우
						inviteMember += "<strong>" + inviteMemberArr[k] + "</strong>님, ";
					}else if(k == inviteMemberArr.length - 1) { // 마지막 사용자일 경우
						inviteMember += "<strong>" + inviteMemberArr[k] + "</strong>님을 초대했습니다.";
					}
				}
				chatContent.setChatContent("<strong>" + chatMemberArr[0] + "</strong>님이 " + inviteMember); // 채팅방 사용자 초대 내용
				cService.registerChatContent(chatContent); // 채팅 등록(채팅방 사용자 초대 공지)
				chatContent.setChatContent("");
				return new Gson().toJson("채팅방 사용자 초대 성공");
			}else {
				return new Gson().toJson("채팅방 사용자 초대 실패");
			}
		}else {
			return new Gson().toJson("채팅방 생성 실패");
		}
	}
	
	// 채팅 상세
	@RequestMapping(value = "/chat/detail.sw")
	public ModelAndView chatView(ModelAndView mv
			, @RequestParam("chatRoomNo") int chatRoomNo
			, @RequestParam("chatRoomTitle") String chatRoomTitle
			, @RequestParam("chatRoomType") int chatRoomType) {
		try {
			List<ChatContent> cList = cService.printAllChat(chatRoomNo);
			if(!cList.isEmpty()) {
				mv.addObject("cList", cList);
				mv.addObject("chatRoomTitle", chatRoomTitle);
				mv.addObject("chatRoomType", chatRoomType);
				mv.setViewName("chat/chatDetail");
			}else {
				mv.addObject("msg", "채팅 목록 조회 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
}

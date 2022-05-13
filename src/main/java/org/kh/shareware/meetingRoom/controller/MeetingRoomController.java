package org.kh.shareware.meetingRoom.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.shareware.member.domain.Member;
import org.kh.shareware.community.domain.Reply;
import org.kh.shareware.meetingRoom.domain.MeetingRoom;
import org.kh.shareware.meetingRoom.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class MeetingRoomController {
	
	@Autowired
	private MeetingRoomService mService;
	
	//예약 페이지 보기
		@RequestMapping(value="/meetionRoom/meetingRoomReservationView.sw", method=RequestMethod.GET)
		public String roomReservationView() {
			return "meetingRoom/meetingRoomReservation";
		}
		
	//예약
		@ResponseBody
		@RequestMapping(value="/meetionRoom/reservation.sw", method=RequestMethod.GET)
			public String roomReservation (
				HttpServletRequest request
				,@RequestParam("meetingDate") String meetingDate 
				,@RequestParam("meetingNo") String meetingNo
				,@RequestParam("meetingTime") String meetingTime) {
			
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setMeetingDate(Date.valueOf(meetingDate));
				meetingRoom.setMeetingNo(meetingNo);
				meetingRoom.setMeetingTime(Integer.parseInt(meetingTime));
				
				
				HttpSession session = request.getSession();
				String memberNum = "";
				Member member = (Member)session.getAttribute("loginUser");
					memberNum = member.getMemberNum();
					meetingRoom.setMemberNum(memberNum);
						
				int result = mService.registerRoom(meetingRoom);
			
				if(result >0) {
					return "success";
				}
				return "fail";
			}
		
		//예약 페이지 로드시 select
		@ResponseBody
		@RequestMapping(value="/meetionRoom/checkTime.sw", method=RequestMethod.GET)
			public void selectCheck (
				@RequestParam("meetingDate") String meetingDate
				,@RequestParam("meetingNo") String meetingNo
				,HttpServletResponse response) throws Exception{
			
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setMeetingDate(Date.valueOf(meetingDate));
				meetingRoom.setMeetingNo(meetingNo);
						
				List<MeetingRoom> mList = mService.selectCheck(meetingRoom);
			
				if(mList != null) {
					Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
					gson.toJson(mList, response.getWriter()); // List를 json로 바꿈
			}
		}
		
		
		
		//예약 확인 페이지 보기
		@RequestMapping(value="/meetionRoom/roomResevationList.sw", method=RequestMethod.GET)
		public String roomCheckView(
				Model model
				,HttpServletRequest request //세션에 로그인 되어있는 아이디로 검색
				) {
			
				HttpSession session = request.getSession();
				String memberNum = "";
				Member member = (Member)session.getAttribute("loginUser");
					memberNum = member.getMemberNum();
				
			List<MeetingRoom> mList = mService.reservationList(memberNum);
			if(mList != null) {
				model.addAttribute("mList", mList);
				return "meetingRoom/meetingRoomCheck";
			}else {
				model.addAttribute("msg", "리스트 출력 실패");
				return "common/errorPage";
			}	
		}
		
		//예약 취소 
		@ResponseBody
		@RequestMapping(value="/meetingRoom/roomReset.sw", method=RequestMethod.GET)
		public String roomReset(
				@RequestParam("meetingDate") String meetingDate
				,@RequestParam("meetingTime") String meetingTime
				,@RequestParam("meetingNo") String meetingNo
				,@RequestParam("memberNum") String memberNum
				) {
					
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setMeetingDate(Date.valueOf(meetingDate));
				meetingRoom.setMeetingNo(meetingNo);
				meetingRoom.setMeetingTime(Integer.parseInt(meetingTime));
				meetingRoom.setMemberNum(memberNum);
						
				int result = mService.modifyRoom(meetingRoom);
						
				if(result > 0) {
					return "success";
				}else{
					return "fail";	
				}
			}
		
}


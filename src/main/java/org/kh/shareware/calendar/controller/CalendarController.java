package org.kh.shareware.calendar.controller;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.alarm.domain.Alarm;
import org.kh.shareware.alarm.service.AlarmService;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.service.CalendarService;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.service.MemberService;
import org.kh.shareware.notice.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService cService;
	
	@Autowired
	private AlarmService alService;
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping( value="/calendar/schWriteView.sw")
	public String scheduleWriteView() {
		return "calendar/mainCalendar";
	}
	
	
	@RequestMapping ( value="/calendar/schRegister.sw", method = RequestMethod.POST)
	public ModelAndView scheduleRegister(ModelAndView mv, 
			@ModelAttribute CalSch calSch, 
			HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			calSch.setMemNum(member.getMemberNum());
			int result = cService.registerSchedule(calSch);
			if(member.getMemberNum().equals("admin")) {
				alarmRegister();
			}
			if(result>0) {
				mv.setViewName("redirect:/calendar/schListView.sw");
			} else {
				mv.addObject("msg", "등록 실패");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.setViewName("common/errorPage");
			mv.addObject("msg", e.toString());
		}
				return mv;
				
	}
	
	@ResponseBody
	@RequestMapping(value="/calendar/schListView.sw", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ModelAndView scheduleList(ModelAndView mv
			,HttpServletRequest request
			, @ModelAttribute CalSch calSch
			, @ModelAttribute Calendar calendar
			) {
//		Calendar calendar = new Calendar();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		calSch.setMemNum(member.getMemberNum());
		List<CalSch> sList = cService.printAllSchedule(calSch);
		calendar.setMemNum(member.getMemberNum());
		List<Calendar> cList = cService.printAllMyCalendar(calendar);
		mv.addObject("cList", cList);
		if(!sList.isEmpty()) {
			mv.addObject("sList", sList);
			
			mv.setViewName("calendar/mainCalendar");
		}else {
			mv.setViewName("calendar/mainCalendar");
		}
		return mv;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/calendar/schDetailView.sw", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public ModelAndView scheduleDetail(ModelAndView mv
			, @RequestParam("schNo") int schNo
			) {
		try {
		CalSch calSch = cService.printOneSchedule(schNo);
		if(calSch != null) {
			mv.addObject("calSch", calSch);
			mv.setViewName("calendar/mainCalendar");
			
		
		} else {
			mv.addObject("msg", "메일 상세 조회 실패");
			mv.setViewName("common/errorPage");
	
	} 
		}catch (Exception e) {
		mv.addObject("msg", e.toString());
		mv.setViewName("common/errorPage");
	}

		return mv;
		
	}
	@ResponseBody
	@RequestMapping(value="/calendar/schModifyView.sw", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ModelAndView scheduleUpdate(ModelAndView mv
			, @ModelAttribute CalSch calSch
			, HttpServletRequest request
			) {
		try{ HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		calSch.setMemNum(member.getMemberNum());
		int result = cService.modifySchedule(calSch);
		if(result>0) {
			mv.setViewName("redirect:/calendar/schListView.sw");
		} else {
			mv.addObject("msg", "등록 실패");
			mv.setViewName("common/errorPage");
		}
	}catch (Exception e) {
		mv.setViewName("common/errorPage");
		mv.addObject("msg", e.toString());
	}
				return mv;
		
	}
	
	
	@RequestMapping( value="/calendar/calWriteView.sw")
	public String calendarWriteView() {
		return "calendar/mainCalendar";
	}
	
	@ResponseBody
	@RequestMapping ( value="/calendar/calRegister.sw", method = RequestMethod.POST)
	public ModelAndView calendarRegister(ModelAndView mv, 
			@ModelAttribute Calendar calendar, 
			HttpServletRequest request
			, @RequestParam(value="calName") String calName) {
		
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			calendar.setMemNum(member.getMemberNum());
			calendar.setCalName(calName);
			int result = cService.registerCalendar(calendar);
			if(result>0) {
				mv.setViewName("redirect:/calendar/schListView.sw");
			} else {
				mv.addObject("msg", "등록 실패");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.setViewName("common/errorPage");
			mv.addObject("msg", e.toString());
		}
				return mv;
				
	}
	
	@ResponseBody
	@RequestMapping(value="/calendar/deleteCal.sw", method=RequestMethod.GET)
	public String calendarDelete(@RequestParam("calNo") int calNo) {
		int result = cService.deleteCalendar(calNo);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 알림 등록
	public void alarmRegister() {
		Alarm alarm = new Alarm();
		CalSch calSch = cService.printLastCalSch(); // 최근 전사 일정 조회
		alarm.setKind("<span class='al-kind cal'>[일정]</span>");
		List<Member> mList = mService.printAllAlarmMember();
		String schName = calSch.getSchName();
		String schDate = calSch.getSchStartDate();
		String schTime = calSch.getSchStartTime();
		for(int i = 0; i < mList.size(); i++) {
			alarm.setMemNum(mList.get(i).getMemberNum()); // 모든 사원에게 알림
			alarm.setAlarmUrl("'/calendar/schListView.sw'");
			if(schTime == null) {
				alarm.setAlarmContent("<span class='al-content'><strong>" + schDate + "</strong>에 <strong>'" + schName + "'</strong> 일정이 등록되었습니다.</span>");
			}else {
				alarm.setAlarmContent("<span class='al-content'><strong>" + schDate + " " + schTime + "</strong>에 <strong>'" + schName + "'</strong> 일정이 등록되었습니다.</span>");
			}
			alService.registerAlarm(alarm); // 알림 등록
		}
	}
}

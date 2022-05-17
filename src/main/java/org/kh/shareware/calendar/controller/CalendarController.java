package org.kh.shareware.calendar.controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.service.CalendarService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService cService;
	
	
	
	
	@RequestMapping( value="/calendar/schWriteView.sw")
	public String scheduleWriteView() {
		return "calendar/mainCalendar";
	}
	
	
	@RequestMapping ( value="/calendar/schRegister.sw", method = RequestMethod.POST)
	public ModelAndView scheduleRegister(ModelAndView mv, 
			@ModelAttribute CalSch calSch, 
			HttpServletRequest request) {
		int result = cService.registerSchedule(calSch);
		
		try {
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
			) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		calSch.setMemNum(member.getMemberNum());
		List<CalSch> sList = cService.printAllSchedule(calSch);
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
}

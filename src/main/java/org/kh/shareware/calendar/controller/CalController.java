package org.kh.shareware.calendar.controller;




import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalController {
	
	@Autowired
	CalendarService cService;
	
	public ModelAndView calendarList(ModelAndView mv, 
			@ModelAttribute Calendar calendar, HttpServletRequest request) {
		int result = cService.registerCalendar(calendar);
		try {
			if(result>0) {
				mv.setViewName("redirect:/calendar/mainCalendar.sw");
			} else {
				mv.addObject("msg", "공지사항 등록 실패");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.setViewName("common/errorPage");
			mv.addObject("msg", e.toString());
		}
				return mv;
	}
}

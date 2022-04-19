package org.kh.shareware.calendar.controller;




import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.domain.Calendar;
import org.kh.shareware.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService cService;
	
	
	
	
	@RequestMapping( value="/calendar/schWriteView.sw")
	public String scheduleWriteView() {
		return "calendar/mainCalendar";
	}
	
	@RequestMapping ( value="/calendar/schRegister.sw ")
	public ModelAndView scheduleRegister(ModelAndView mv, 
			@ModelAttribute CalSch calSch, HttpServletRequest request) {
		int result = cService.registerSchedule(calSch);
		try {
			if(result>0) {
				mv.setViewName("redirect:/calendar/mainCalendar.sw");
			} else {
				mv.addObject("msg", "등록 실");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.setViewName("common/errorPage");
			mv.addObject("msg", e.toString());
		}
				return mv;
	}
}

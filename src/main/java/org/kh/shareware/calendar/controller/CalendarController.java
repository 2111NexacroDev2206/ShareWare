package org.kh.shareware.calendar.controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping ( value="/calendar/schRegister.sw",method = RequestMethod.POST)
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
	@RequestMapping(value="/calendar/schListView.sw", method = RequestMethod.GET)
	public ModelAndView scheduleList(ModelAndView mv
			) {
		
		List<CalSch> sList = cService.printAllSchedule();
		if(!sList.isEmpty()) {
			mv.addObject("sList", sList);
			mv.setViewName("calendar/mainCalendar");
		}else {
			mv.setViewName("calendar/mainCalendar");
		}
		return mv;
		
	}
}

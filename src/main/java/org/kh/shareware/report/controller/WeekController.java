package org.kh.shareware.report.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.report.domain.Daily;
import org.kh.shareware.report.domain.Week;
import org.kh.shareware.report.service.DailyService;
import org.kh.shareware.report.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeekController {
	
	@Autowired
	private WeekService service;
	
	//주간 업무 등록 화면 
		@RequestMapping(value="/report/weekWriteView.sw")
		public String weekWriteView(Model model) {
			Date nowTime = new Date();
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		    model.addAttribute("nowTime", sf.format(nowTime));
			return "report/weekWriteForm";
		}
		
	//일일 업무 등록 
		@RequestMapping(value="/report/weekRegister.sw", method=RequestMethod.POST)
		public ModelAndView weekRegister(ModelAndView mv
				,@ModelAttribute Week week
				,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
				,HttpServletRequest request){
		
			int result = service.registerWeek(week);
			if(result > 0) {
				mv.setViewName("redirect:/report/weekList.sw");
			}else {
				mv.addObject("msg", "업무일지 등록 실패");
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
}

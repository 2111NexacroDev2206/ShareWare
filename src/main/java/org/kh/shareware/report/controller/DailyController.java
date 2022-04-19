package org.kh.shareware.report.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.report.domain.Daily;
import org.kh.shareware.report.service.DailyService;
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
public class DailyController {

	@Autowired
	private DailyService service;
	
	//일일 업무 목록
	@RequestMapping(value="/report/dailyList.sw", method = RequestMethod.GET)
	public ModelAndView dailyListView(ModelAndView mv) {
		try {
			List<Daily> dList = service.printAllDaily();
			if(!dList.isEmpty()) {
				mv.addObject("dList", dList);
				mv.setViewName("report/dailyList");
			}else {
				mv.addObject("msg", "업무일지 조회 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	//일일 업무 등록 화면 
	@RequestMapping(value="/report/dailyWriteView.sw")
	public String dailyWriteView(Model model) {
		Date nowTime = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    model.addAttribute("nowTime", sf.format(nowTime));
		return "report/dailyWriteForm";
	}
	
	//일일 업무 등록 
	@RequestMapping(value="/report/dailyRegister.sw", method=RequestMethod.POST)
	public ModelAndView dailyRegister(ModelAndView mv
			,@ModelAttribute Daily daily
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,HttpServletRequest request){
	
		
		int result = service.registerDaily(daily);
		if(result > 0) {
			mv.setViewName("redirect:/report/dailyList.sw");
		}else {
			mv.addObject("msg", "업무일지 등록 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
}
	


	

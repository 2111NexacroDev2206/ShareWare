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
	
	//일일 업무 상세화면 
	 @RequestMapping(value="/report/dailyDetail.sw", method=RequestMethod.GET)
	   public ModelAndView dailyDetailView(
			   ModelAndView mv
				, @RequestParam(value = "drNo", required =false) Integer drNo) {
	try {
		Daily daily = service.printOneByNo(drNo);
		if(daily != null) {
			mv.addObject("daily", daily);
			mv.setViewName("report/dailyDetail");
		}else {
			mv.addObject("msg", "공지사항 상세조회 실패");
			mv.setViewName("common/errorPage");
		}
	}catch(Exception e) {
		mv.addObject("msg", e.toString());
		mv.setViewName("common/errorPage");
	}
	return mv;
	 }
	//일일 업무 수정 화면 
	 @RequestMapping(value="/report/dailyModifyView.sw", method=RequestMethod.GET)
		public String dailyModifyView(
				  Model model
				, @RequestParam(value = "drNo", required =false) Integer drNo) {
			try {
				// 수정화면에 필요한 데이터 DB 가져오기
				Daily daily = service.printOneByNo(drNo);
				if(daily != null) {
					model.addAttribute("daily", daily);
					return "report/dailyUpdateView";
				}else {
					// 데이터가 없을 때 메시지 출력
					model.addAttribute("msg", "No Data Found!!");
					return "common/errorPage";
				}
			}catch(Exception e) {
				model.addAttribute("msg", e.toString());
				return "common/errorPage";
			}
			
		}
	 //일일 업무 수정
	 @RequestMapping(value="/report/dailyUpdate.sw", method=RequestMethod.POST)
		public ModelAndView dailyUpdate(
				ModelAndView mv
				, @ModelAttribute Daily daily
				// 400 오류 방지
				, HttpServletRequest request) {
			try {
				// 디비에 해당 데이터 저장(비즈니스 로직)
				int result = service.modifyDaily(daily);
				if(result > 0) {
					mv.setViewName("report/dailyDetail");
				}else {
					mv.addObject("msg", "업무일지 수정실패");
					mv.setViewName("common/errorPage");
				}
			} catch(Exception e) {
				mv.addObject("msg", e.toString());
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
	 
	//일일 업무 삭제 
	 @RequestMapping(value="/report/dailyDelete.sw", method=RequestMethod.GET)
	 public String dailyDelete(
			 Model model
			 , @RequestParam("drNo") int drNo) {
		 try {
			 int result = service.removeDaily(drNo);
			 if(result > 0) {
				 return "redirect:/report/dailyList.sw";
			 }else
				 model.addAttribute("msg", "업무일지 삭제 실패");
			 	 return "common/errorPage";
		 }catch(Exception e) {
				 model.addAttribute("msg", e.toString());
				 return("common/errorPage");
			}
}
}
	


	

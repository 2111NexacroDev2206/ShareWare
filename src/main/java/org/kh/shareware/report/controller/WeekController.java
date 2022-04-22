package org.kh.shareware.report.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	//주간 업무 목록
	@RequestMapping(value="/report/weekList.sw", method = RequestMethod.GET)
	public ModelAndView weekListView(ModelAndView mv) {
		try {
			List<Week> wList = service.printAllWeek();
			if(!wList.isEmpty()) {
				mv.addObject("wList", wList);
				mv.setViewName("report/weekList");
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
	//주간 업무 등록 화면 
		@RequestMapping(value="/report/weekWriteView.sw")
		public String weekWriteView(Model model) {
			Date nowTime = new Date();
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		    model.addAttribute("nowTime", sf.format(nowTime));
			return "report/weekWriteForm";
		}
		
		//주간 업무 등록 
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
		
		//주간 업무 상세화면 
		 @RequestMapping(value="/report/weekDetail.sw", method=RequestMethod.GET)
		   public ModelAndView weekDetailView(
				   ModelAndView mv
					, @RequestParam(value = "wrNo", required =false) Integer wrNo) {
		try {
			Week week = service.printOneByNo(wrNo);
			if(week != null) {
				mv.addObject("week", week);
				mv.setViewName("report/weekDetail");
			}else {
				mv.addObject("msg", "업무일지 상세조회 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
		
		 }
		//주간업무 수정 화면 
		 @RequestMapping(value="/report/weekModifyView.sw", method=RequestMethod.GET)
			public String weekModifyView(
					  Model model
					, @RequestParam(value = "wrNo", required =false) Integer wrNo) {
				try {
					// 수정화면에 필요한 데이터 DB 가져오기
					Week week = service.printOneByNo(wrNo);
					if(week != null) {
						model.addAttribute("week", week);
						return "report/weekUpdateView";
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
		 //주간 업무 수정 
//		 @RequestMapping(value="/report/weekUpdate.sw", method=RequestMethod.POST)
//			public ModelAndView weekUpdate(
//					ModelAndView mv
//					, @ModelAttribute Week week
//					, HttpServletRequest request) {
//				try {
//					int result = service.modifyWeek(week)
//					if(result > 0) {
//						mv.setViewName("report/weekDetail");
//					}else {
//						mv.addObject("msg", "업무일지 수정실패");
//						mv.setViewName("common/errorPage");
//					}
//				} catch(Exception e) {
//					mv.addObject("msg", e.toString());
//					mv.setViewName("common/errorPage");
//				}
//				return mv;
//			}
		 
		 //주간업무 삭제
		//일일 업무 삭제 
		 @RequestMapping(value="/report/weekDelete.sw", method=RequestMethod.GET)
		 public String weekDelete(
				 Model model
				 , @RequestParam("wrNo") int wrNo) {
			 try {
				 int result = service.removeWeek(wrNo);
				 if(result > 0) {
					 return "redirect:/report/weekList.sw";
				 }else
					 model.addAttribute("msg", "업무일지 삭제 실패");
				 	 return "common/errorPage";
			 }catch(Exception e) {
					 model.addAttribute("msg", e.toString());
					 return("common/errorPage");
				}
	}
}

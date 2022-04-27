package org.kh.shareware.attendance.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.common.Pagination;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService aService;
	
	
	// 출근 등록
	@RequestMapping(value = "/attendance/registerAtt.sw", method = RequestMethod.POST)
	public String registerAttendance(HttpServletRequest request, 
				Model model, @ModelAttribute Attendance attendance) {
		HttpSession session = request.getSession();
		session.getAttribute("loginUser");
		Member value = (Member) session.getAttribute("loginUser");
		try{
			if (value != null) {
				attendance.setMemNum(value.getMemberNum()); // 사원번호
				// 지각이면 
				attendance.setAttStatus("지각");
				attendance.setAttStatus("출근");
				int result = aService.registerAttendance(attendance);
				if(result > 0) {
					return "redirect:/attendance/attListViewEmp.sw";
				}else {
					model.addAttribute("msg", "출근 등록 실패!");
					return "common/errorPage";
				}
			}else {
				model.addAttribute("msg", "로그인 실패!");
				return "common/errorPage";
			}
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
	}
	// 퇴근 등록
		@RequestMapping(value = "/attendance/modifyAtt.sw", method = RequestMethod.POST)
		public String modifyAttendance(HttpServletRequest request, 
					Model model, @ModelAttribute Attendance attendance) {
			HttpSession session = request.getSession();
			session.getAttribute("loginUser");
			Member value = (Member) session.getAttribute("loginUser");
			try {
				if (value != null) {
					attendance.setMemNum(value.getMemberNum()); // 사원번호
					int result = aService.modifyAttendance(attendance);
					if(result > 0) {
						return "redirect:/attendance/attListViewEmp.sw";
					}else {
						model.addAttribute("msg", "퇴근 등록 실패!");
						return "common/errorPage";
					}
				}else {
					model.addAttribute("msg", "로그인 실패!");
					return "common/errorPage";
				}
			}catch(Exception e) {
				model.addAttribute("msg", e.toString());
				return "common/errorPage";
			}
		}
	
	//출퇴근 리스트
	@RequestMapping(value="/attendance/attListViewEmp.sw", method=RequestMethod.GET)
	public String attListViewEmp(
			Model model
			, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = aService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Attendance> aList = aService.printAll(pi);
		if(!aList.isEmpty()) {
			model.addAttribute("aList", aList);
			model.addAttribute("pi", pi);
		}
		return "attendance/attListViewEmp";
	}
	

	//날짜 검색 (연도/월)
//	@RequestMapping(value="/attendance/searchDate.sw")
//	public ModelAndView searchDate(HttpServletRequest request ,ModelAndView mav) {
//		String colName =  request.getParameter("colName");
//		String serchWord = request.getParameter("searchWord");
//		
//		HashMap<String,String> paraMap = new HashMap<String,String>();
//		paraMap.put("colName", colName);
//		paraMap.put("colName", serchWord);
//		
//		List<Attendance>aList = aService.searchDate();
//		mav.addObject("aList", aList);
//		
//		return mav;
//	}
			
		
	
	
}

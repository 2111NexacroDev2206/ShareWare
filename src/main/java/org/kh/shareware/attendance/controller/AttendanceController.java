package org.kh.shareware.attendance.controller;

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

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService aService;
	
	
	// 출퇴근 등록
	@RequestMapping(value = "/attendance/registerAtt.sw", method = RequestMethod.POST)
	public String registerAttendance(HttpServletRequest request, 
				Model model, @ModelAttribute Attendance attendance) {
		HttpSession session = request.getSession();
		session.getAttribute("loginUser");
		Member value = (Member) session.getAttribute("loginUser");
		if (value.getMemberNum() != null) {
			int result = aService.registerAttendance(attendance);
			return "redirect:/attendance/attListViewEmp";
		}else {
			model.addAttribute("msg", "등록 실패!");
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
			return "attendance/attListViewEmp";
		}else {
			model.addAttribute("msg", "근태조회 실패");
			return "common/errorPage";
		}
	}
	
}

package org.kh.shareware.attendance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AttendanceController {

	@Autowired
	private AttendanceService aService;
	
	// 출퇴근 등록
	@RequestMapping(value = "/attendance/registerAtt.sw", method = RequestMethod.POST)
	public String registerAttendance(HttpServletRequest request, Model model, @ModelAttribute Attendance attendance) {
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
}

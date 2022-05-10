package org.kh.shareware.leave.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.leave.domain.Leave;
import org.kh.shareware.leave.service.LeaveService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LeaveController {

	@Autowired
	private LeaveService lService;
	
	//연차 통계
	@RequestMapping(value="/leave/leaveStatsView.sw",method=RequestMethod.GET)
	public String leaveListViewEmp(HttpServletRequest request, 
			Model model) {
		HttpSession session = request.getSession(); //사원번호 값 가져오기
		session.getAttribute("loginUser");
		Member value = (Member) session.getAttribute("loginUser");
		String memNum = value.getMemberNum();
		
		float tLeaveCount = lService.printLeaveTotal(memNum);
		float uLeaveCount = lService.printLeaveUse(memNum);
		float rLeaveCount = tLeaveCount - uLeaveCount;
		if(tLeaveCount != 0) {
			model.addAttribute("tLeaveCount",tLeaveCount); //총연차
			model.addAttribute("uLeaveCount",uLeaveCount); //사용연차
			model.addAttribute("rLeaveCount",rLeaveCount); //사용연차
			return "attendance/leaveListView";
		}else {
			model.addAttribute("msg", "연차 통계 조회 실패");
			return "common/errorPage";
		}
	}
}



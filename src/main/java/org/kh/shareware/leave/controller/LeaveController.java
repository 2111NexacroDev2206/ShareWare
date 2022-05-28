package org.kh.shareware.leave.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.Search;
import org.kh.shareware.leave.domain.LeaveList;
import org.kh.shareware.leave.service.LeaveService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

@Controller
public class LeaveController {

	@Autowired
	private LeaveService lService;
	
	//연차 통계
	@RequestMapping(value="/leave/leaveStatsView.sw",method=RequestMethod.GET)
	public String leaveStatsView(HttpServletRequest request, 
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
	
	
	//연차 리스트
	@RequestMapping(value="/leave/leaveListView.sw", method=RequestMethod.GET)
	public String leaveListView(
			HttpServletRequest request
			, Model model){
		HttpSession session = request.getSession(); //사원번호 값 가져오기
		session.getAttribute("loginUser");
		Member value = (Member) session.getAttribute("loginUser");
		String memNum = value.getMemberNum();
		float tLeaveCount = lService.printLeaveTotal(memNum); //통계
		float uLeaveCount = lService.printLeaveUse(memNum);
		float rLeaveCount = tLeaveCount - uLeaveCount;
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy");
		List<LeaveList> lList = lService.printAll(memNum+sf.format(date));
		model.addAttribute("tLeaveCount",tLeaveCount); //총연차 //통계
		model.addAttribute("uLeaveCount",uLeaveCount); //사용연차
		model.addAttribute("rLeaveCount",rLeaveCount); //사용연차
		model.addAttribute("lList", lList);
		model.addAttribute("listCondition", "leave");
		model.addAttribute("myCondition", "attendance");
		model.addAttribute("year", sf.format(date));
		return "/attendance/leaveListView";
	}
	
	//날짜 검색 
	@PostMapping("/leave/searchDate.sw")
	public String searchDate(String date, HttpSession session, Model model) {			
		
		Member value = (Member) session.getAttribute("loginUser");
		String memNum = value.getMemberNum();  //A02022
		float tLeaveCount = lService.printLeaveTotal(memNum);
		float uLeaveCount = lService.printLeaveUse(memNum+date);
		float rLeaveCount = tLeaveCount - uLeaveCount;
		List<LeaveList> lList = lService.printAll(memNum+date);
		model.addAttribute("tLeaveCount",tLeaveCount); //총연차
		model.addAttribute("uLeaveCount",uLeaveCount); //사용연차
		model.addAttribute("rLeaveCount",rLeaveCount); //사용연차
		if(!lList.isEmpty()) {
			model.addAttribute("lList", lList);
		}	
		model.addAttribute("year", date);
		model.addAttribute("listCondition", "leave");
		model.addAttribute("myCondition", "attendance");
		return "attendance/leaveListView";
	}
	
	//넥사크로 - 연차조회
	@RequestMapping(value = "/admin/leave/leaveList.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberLeaveList(@ParamVariable(name = "year") String year) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		List<LeaveList> lList = lService.printAllLeave(year);
		if(!lList.isEmpty()) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addDataSet("out_leave", lList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
	
	//넥사크로 - 연차조회 검색
	@RequestMapping(value = "/admin/leave/leaveSearchList.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberSearchList(@ParamVariable(name = "year") String year
			, @ParamVariable(name = "searchCondition") String searchCondition
			, @ParamVariable(name = "searchValue") String searchValue) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		Search search = new Search();
		search.setSearchCondition(searchCondition);
		search.setSearchValue(searchValue);
		search.setType(year);
		List<LeaveList> lList = lService.printAllSearchLeave(search);
		if(!lList.isEmpty()) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addDataSet("out_leave", lList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
}



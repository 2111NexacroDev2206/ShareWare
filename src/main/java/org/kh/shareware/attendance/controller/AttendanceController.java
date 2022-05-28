package org.kh.shareware.attendance.controller;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.domain.Stats;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

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
				// 지각
				LocalTime now = LocalTime.now();
				int hour = now.getHour();
				int second = now.getSecond();
					// 시 분 초 -> 9, 0, 1 -> 지각
					if(hour >= 9 && second > 0) {
						attendance.setAttStatus("지각");
					}else {
						attendance.setAttStatus("출근");
					}
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
					//조퇴
					LocalTime now = LocalTime.now();
					int hour = now.getHour();
					int second = now.getSecond();
						if(hour >= 13 && hour <= 18) {
							attendance.setAttStatus("조퇴");
						}else {
							attendance.setAttStatus("퇴근");
						}
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
			, HttpSession session
			, @RequestParam(value="page", required=false) Integer page
			, @RequestParam(value="date", required=false) String date){
		Member value = (Member) session.getAttribute("loginUser");
		Date nowTime = new Date(); // 현재 날짜 가져오기
		SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM");
		String memNum = value.getMemberNum() + sf.format(nowTime);
		List<Attendance> aList = aService.printAll(memNum);
		List<Stats> sList = aService.printStats(memNum); //통계
		if(!aList.isEmpty()) {
			model.addAttribute("sList", sList); //통계
			model.addAttribute("aList", aList);
		}		
		model.addAttribute("myCondition", "attendance");
		model.addAttribute("listCondition", "attendance");
		return "attendance/attListViewEmp";
	}
	

	//날짜 검색 (연도/월)
	@PostMapping("/attendance/searchDate.sw")
	public String searchDate(String date, HttpSession session, Model model) {			
		Member value = (Member) session.getAttribute("loginUser");
		String memNum = value.getMemberNum()+date;  //A02022-06
		List<Attendance> aList = aService.printAll(memNum);
		List<Stats> sList = aService.printStats(memNum); //통계
		if(!aList.isEmpty()) {
			model.addAttribute("sList", sList); //통계
			model.addAttribute("aList", aList);
		}	
		model.addAttribute("myCondition", "attendance");
		model.addAttribute("listCondition", "attendance");
		model.addAttribute("date", date);
		return "attendance/attListViewEmp";
	}
	
	//넥사크로-근태관리 리스트
		@RequestMapping(value = "/admin/attendance/attList.sw", method = RequestMethod.POST)
		public NexacroResult adminAttList(@ParamVariable(name = "inVar") String inVar) {
			int 	nErrorCode = 0;
			String 	strErrorMsg = "START";
			NexacroResult result = new NexacroResult();
			List<Attendance> aList = aService.printAllAtt(inVar);
			if(!aList.isEmpty()) {
				nErrorCode = 0;
				strErrorMsg = "SUCC";
			} else {
				nErrorCode = -1;
				strErrorMsg = "Fail";
			}
			result.addDataSet("out_att", aList);
			result.addVariable("ErrorCode", nErrorCode);
			result.addVariable("ErrorMsg", strErrorMsg);
			return result;
		}
	//넥사크로-근태관리 검색
		@RequestMapping(value = "/admin/attendance/searchList.sw", method = RequestMethod.POST)
		public NexacroResult adminAttSearchList(@ParamVariable(name = "inVar") String inVar
				, @ParamVariable(name = "searchCondition") String searchCondition
				, @ParamVariable(name = "searchValue") String searchValue) {
			int 	nErrorCode = 0;
			String 	strErrorMsg = "START";
			NexacroResult result = new NexacroResult();
			Search search = new Search();
			search.setSearchCondition(searchCondition);
			search.setSearchValue(searchValue);
			search.setType(inVar);
			List<Attendance> aList = aService.printAllSearchAtt(search);
			if(!aList.isEmpty()) {
				nErrorCode = 0;
				strErrorMsg = "SUCC";
			} else {
				nErrorCode = -1;
				strErrorMsg = "Fail";
			}
			result.addDataSet("out_att", aList);
			result.addVariable("ErrorCode", nErrorCode);
			result.addVariable("ErrorMsg", strErrorMsg);
			return result;
		}
		//넥사크로-근태관리 통계
		@RequestMapping(value = "/admin/attendance/attStats.sw", method = RequestMethod.POST)
		public NexacroResult adminAttStats(@ParamVariable(name = "inVar") String inVar) {
			int 	nErrorCode = 0;
			String 	strErrorMsg = "START";
			NexacroResult result = new NexacroResult();
			List<Stats> sList = aService.printAttStats(inVar);			
			if(!sList.isEmpty()) {
				nErrorCode = 0;
				strErrorMsg = "SUCC";
			} else {
				nErrorCode = -1;
				strErrorMsg = "Fail";
			}
			
			result.addDataSet("out_attSts", sList);
			result.addVariable("ErrorCode", nErrorCode);
			result.addVariable("ErrorMsg", strErrorMsg);
			return result;
		}
}

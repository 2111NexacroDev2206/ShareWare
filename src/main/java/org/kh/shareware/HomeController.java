package org.kh.shareware;

import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.approval.service.ApprovalService;
import org.kh.shareware.attendance.domain.Attendance;
import org.kh.shareware.attendance.service.AttendanceService;
import org.kh.shareware.calendar.domain.CalSch;
import org.kh.shareware.calendar.service.CalendarService;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.notice.domain.Notice;
import org.kh.shareware.notice.service.NoticeService;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class HomeController {
	
	@Autowired
	private ApprovalService aService;
	
	@Autowired
	private AttendanceService tService;
	
	@Autowired
	private NoticeService nService;
	
	@Autowired
	private ProjectService pService;
	
	@Autowired
	private CalendarService cService;
	
	@RequestMapping(value = "/home.sw", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("myCondition", "home");
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		// 내 정보
		int appCount = aService.homeAppCount(member.getMemberNum()); // 결재 대기 문서
		int draftCount = aService.homeDraftCount(member.getMemberNum()); // 결재 진행 문서
		int expCount = aService.homeExpCount(member.getMemberNum()); // 결재 예정 문서
		model.addAttribute("appCount", appCount);
		model.addAttribute("draftCount", draftCount);
		model.addAttribute("expCount", expCount);
		// 공지사항
		List<Notice> nList = nService.homeNotice();
		model.addAttribute("nList", nList);
		// 프로젝트 관리
		List<Project> pList = pService.homeProject(member.getMemberNum());
		model.addAttribute("pList", pList);
		return "home";
	}
	
	// 근태 관리 시간 조회
	@ResponseBody
	@RequestMapping(value="/attendance/workTime.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String workTime(@ModelAttribute Attendance attendance
			, @RequestParam("memberNum") String memberNum) {
		attendance = tService.homeAttTime(memberNum);
		return new Gson().toJson(attendance);
	}
	
	// 출근 등록
	@ResponseBody
	@RequestMapping(value="/attendance/workStart.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String workStart(@ModelAttribute Attendance attendance
			, @RequestParam("memberNum") String memberNum) {
		attendance.setMemNum(memberNum);
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int second = now.getSecond();
			if(hour >= 9 && second > 0) {
				attendance.setAttStatus("지각");
			}else {
				attendance.setAttStatus("출근");
			}
		int result = tService.registerAttendance(attendance);
		return new Gson().toJson(result);
	}
	
	// 퇴근 등록
	@ResponseBody
	@RequestMapping(value="/attendance/workEnd.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String workEnd(@ModelAttribute Attendance attendance
			, @RequestParam("memberNum") String memberNum) {
		attendance.setMemNum(memberNum);
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
			if(hour >= 13 && hour <= 18) {
				attendance.setAttStatus("조퇴");
			}else {
				attendance.setAttStatus("퇴근");
			}
		int result = tService.modifyAttendance(attendance);
		return new Gson().toJson(result);
	}
	
	// 일정 목록
	@ResponseBody
	@RequestMapping(value="/calendar/homeListView.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String calendarListView(@ModelAttribute CalSch calSch
			, @RequestParam("selectDay") String calDate
			, @RequestParam("memberNum") String memberNum) {
		calSch.setMemNum(memberNum);
		calSch.setSchStartDate(calDate);
		List <CalSch> cList = cService.printAllHomeCal(calSch);
		return new Gson().toJson(cList);
	}
	
	// 일정 상세
	@ResponseBody
	@RequestMapping(value="/calendar/homeDetailView.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String calendarDetailView(@RequestParam("schNo") int schNo) {
		CalSch calSch = cService.printOneHomeCal(schNo);
		return new Gson().toJson(calSch);
	}
}

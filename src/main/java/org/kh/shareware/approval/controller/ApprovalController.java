package org.kh.shareware.approval.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.approval.service.ApprovalService;
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
public class ApprovalController {
	
	@Autowired
	private ApprovalService aService;

	// 기안서 작성 페이지
	@RequestMapping(value = "/approval/draftDocWriteView.sw")
	public String docWriteView(Model model) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", "draft");
		Date nowTime = new Date(); // 현재 날짜 가져오기
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("nowTime", sf.format(nowTime));
		return "approval/draftDocWrite";
	}
	
	// 기안서 결재 요청
	@RequestMapping(value = "/approval/draftDocWrite.sw", method = RequestMethod.POST)
	public ModelAndView docRegister(ModelAndView mv
			, @ModelAttribute AppDocument appDoc
			, @ModelAttribute Approval app
			, @ModelAttribute AppReference ref
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile[]
			, @RequestParam(value="appMemNum") String appMemNum
			, @RequestParam(value="refMemNum") String refMemNum
			, HttpServletRequest request) {
		try {
			int dResult = aService.registerDoc(appDoc); // 기안서 등록
			int aResult = 0; // 결재자 등록 결과 변수 선언
			int rResult = 0; // 참조자 등록 결과 변수 선언
			// 결재자
			String[] appArray = appMemNum.split(","); // 배열에 결재자 넣기
			for(int i = 0; i < appArray.length; i++) {
				app.setMemNum(appArray[i]); // 결재자 사원번호
				app.setAppLevel(i+1); // 결재자 순번
				aResult = aService.registerApp(app); // 결재자 등록
			}
			// 참조자
			if(!refMemNum.isEmpty()) { // 참조자가 있는 경우에만
				String[] refArray = refMemNum.split(","); // 배열에 참조자 넣기
				for(int i = 0; i < refArray.length; i++) {
					ref.setMemNum(refArray[i]); // 참조자 사원번호
					rResult = aService.registerRef(ref); // 참조자 등록
				}
			}else {
				rResult = 1;
			}
			if(dResult > 0 && aResult > 0 && rResult > 0) {
				mv.addObject("msg", "등록 성공");
			}else {
				mv.addObject("msg", "등록 실패");
			}
			mv.addObject("loc", "/approval/draftDocWriteView.sw");
			mv.setViewName("common/msg");
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
}

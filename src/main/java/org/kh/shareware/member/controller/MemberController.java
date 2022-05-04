package org.kh.shareware.member.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.Search;
import org.kh.shareware.member.common.PageInfo;
import org.kh.shareware.member.common.Pagination;
import org.kh.shareware.member.domain.Division;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.member.service.MemberService;
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
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="member/loginView.sw",method=RequestMethod.GET)
	public String memberLoginView() {
	return "member/memberLogin";
	}
	
	//로그인
	@RequestMapping(value="/member/login.sw", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, Model model, @ModelAttribute Member member) {
		
			Member loginUser = mService.loginMember(member);
			if(loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				return "redirect:/home.sw";
			}else {
				request.setAttribute("msg", "회원 조회 실패");
				return "common/errorPage";
			}
	}
	
	//로그아웃
	@RequestMapping(value="/member/logout.sw", method=RequestMethod.GET)
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			return "redirect:/home.sw";
		}else {
			request.setAttribute("msg", "로그아웃 실패!");
			return "common/errorPage";
		}
	}
	
	//마이페이지
	@RequestMapping(value="/member/myInfo.sw", method=RequestMethod.GET)
	public String memberMyInfo(HttpServletRequest request) {
		
		return "member/myInfo";
	}
	
	//주소록
	@RequestMapping(value="/member/address.sw", method=RequestMethod.GET)
	public String addressView(
			Model model
			, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = mService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Member> mList = mService.printAll(pi);
		if(!mList.isEmpty()) {
			model.addAttribute("mList", mList);
			model.addAttribute("pi", pi);
			return "member/addressView";
		}else {
			model.addAttribute("msg", "주소록 조회 실패");
			return "common/errorPage";
		}
	}
	
	// 사원 목록(전자결재 결재자, 참조자 선택 모달창)
	@ResponseBody
	@RequestMapping(value = "/modal/member/list.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalMemberList(Model model) {
		List<Member> mList = mService.modalPrintAll();
		if(!mList.isEmpty()) {
			return new Gson().toJson(mList);
		}
		return null;
	}
	
	// 사원 목록 검색(전자결재 결재자, 참조자 선택 모달창)
	@ResponseBody
	@RequestMapping(value = "/modal/member/search.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalMemberSearch(Model model, @ModelAttribute Search search) {
		List<Member> mList = mService.modalPrintSearch(search);
		if(!mList.isEmpty()) {
			return new Gson().toJson(mList);
		}
		return null;
	}
	
	//조직도
	@RequestMapping(value="/member/organizationView.sw", method=RequestMethod.GET)
	public String organizationView(Model model){
			List<Division> oList = mService.printOrganization();
			if(!oList.isEmpty()) {
				model.addAttribute("oList", oList);
				return "/member/organizationView";
			}else {
				model.addAttribute("msg", "조직도 조회 실패");
				return "common/errorPage";
			}
	
	}
}

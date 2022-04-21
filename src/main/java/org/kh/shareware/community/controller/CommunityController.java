package org.kh.shareware.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.service.CommunityService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
//글작성 페이지 보기
	@RequestMapping(value="/community/WriteView.sw", method=RequestMethod.GET)
	public String CommunityWriteView() {
		return "community/communityWriteForm";
	}

//디테일 페이지 보기
	@RequestMapping(value="/community/detail.sw", method=RequestMethod.GET)
	public String datailCommunity(
			Model model
			,HttpSession session
			,@RequestParam("comNo") Integer comNo) {
		
		//게시글 번호로 검색
		Community community = cService.detailCommunity(comNo);
		if(community != null) {
			model.addAttribute("community",community);
			return "community/communityDetail";
		}else {
			model.addAttribute("msg", "게시글 상세보기 실패");
			return "common/errorPage";
		}	
	}
	
//리스트 페이지 보기
	@RequestMapping(value="/community/list.sw", method=RequestMethod.GET)
	public String CommunityListView(
			Model model) {
		List<Community> cList = cService.listCommunity();
		if(cList != null) {
			model.addAttribute("cList", cList);
			return "community/communityList";
		}else {
			model.addAttribute("msg", "리스트 출력 실패");
			return "common/errorPage";
		}
	}
	
	//글삭제
	@ResponseBody
	@RequestMapping(value="/community/deleteCommunity.sw", method=RequestMethod.GET)
	public String removeCommunity(
		@RequestParam("comNo") Integer comNo) {
		int result =cService.removeCommunity(comNo);
		if(result >0) {
			return "success";
		}
		return "fail";
	}
		
	
//글작성
	@RequestMapping(value="/community/register.sw", method=RequestMethod.POST)
	public String resisterCommunity(
			Model model
			,HttpServletRequest request //session 에 저장 된 아이디를 가져와야함
			, @ModelAttribute Community community) {
		
		HttpSession session = request.getSession();
		String memberNum = ((Member)session.getAttribute("loginUser")).getMemberNum();
		community.setMemberNum(memberNum);
		
		int result = cService.resisterCommunity(community);
		if(result>0) {
			return "community/communityDetail";
		}else {
			model.addAttribute("msg", "게시글 등록 실패");
			return "common/errorPage";
		}
	}	
}

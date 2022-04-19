package org.kh.shareware.community.controller;

import java.util.List;

import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
//글작성 페이지 보기
	@RequestMapping(value="/community/WriteView.sw", method=RequestMethod.GET)
	public String CommunityWriteView(
			Model model) {
		
		List<Community> cList = cService.listCommunity();
		if(cList != null) {
			return "community/communityWriteForm";
		}else {
			model.addAttribute("msg", "게시글 등록 실패");
			return "common/errorPage";
		}
	}

//디테일 페이지 보기
	@RequestMapping(value="/community/Detail.sw", method=RequestMethod.GET)
	public String CommunityDetilView() {
		return "community/commnityDetail";
	}
	
//리스트 페이지 보기
	@RequestMapping(value="/community/List.sw", method=RequestMethod.GET)
	public String CommunityListView() {
		return "community/commnityList";
	}
		
	
//글작성
	@RequestMapping(value="/community/register.sw", method=RequestMethod.POST)
	public String resisterCommunity(
			Model model
			, @ModelAttribute Community community) {
		
		int result = cService.resisterCommunity(community);
		if(result>0) {
			return "community/commnityDetail";
		}else {
			model.addAttribute("msg", "게시글 등록 실패");
			return "common/errorPage";
		}
	}	
}

package org.kh.shareware.community.controller;

import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
//글작성 페이지 보기
	@RequestMapping(value="/Community/WriteView.sh", method=RequestMethod.GET)
	public String CommunityWriteView() {
		return "commnityWriterForm";
	}
//글작성
	@RequestMapping(value="/community/register.sw", method=RequestMethod.POST)
	public String resisterCommunity(
			Model model
			, @ModelAttribute Community community) {
		
		int result = cService.resisterCommunity(community);
		if(result>0) {
			return "redirect:/communityList.sh";
		}else {
			model.addAttribute("msg", "게시글 등록 실패");
			return "common/errorPage";
		}
	}
}

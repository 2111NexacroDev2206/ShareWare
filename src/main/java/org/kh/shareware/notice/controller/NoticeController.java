package org.kh.shareware.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.notice.domain.Notice;
import org.kh.shareware.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService nService;
	//리스트 보기
	@RequestMapping(value ="/notice/list.sw", method=RequestMethod.GET)
	public String NoticeListView(
			Model model
			,@RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		int totalCount = nService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Notice> nList = nService.listNotice(pi);
		if(nList != null) {
			model.addAttribute("nList", nList);
			model.addAttribute("pi", pi);
			model.addAttribute("listCondition", "notice");
			model.addAttribute("myCondition", "board");
			return "notice/noticeList";
		}else {
			model.addAttribute("msg", "리스트 출력 실패");
			return "common/errorPage";
		}
	}
	
	//디테일 페이지 보기
		@RequestMapping(value="/notice/detail.sw", method=RequestMethod.GET)
		public String datailNotice(
				Model model
				,HttpServletRequest request
				,@RequestParam("noticeNo") Integer noticeNo) {
			//조회수 증가
			nService.countViewNotice(noticeNo);
		
			
			//게시글 번호로 검색
			Notice notice = nService.detailNotice(noticeNo);

			
			if(notice != null) {
				model.addAttribute("myCondition", "board");
				model.addAttribute("notice",notice);
				return "notice/noticeDetail";
			}else {
				model.addAttribute("msg", "게시글 상세보기 실패");
				return "common/errorPage";
			}
		}

	//검색
	@RequestMapping(value="/notice/search.sw", method=RequestMethod.GET)
	public ModelAndView noticeSearchList(
			ModelAndView mv
			, @ModelAttribute Search search
			, HttpServletRequest request
			,@RequestParam(value="page", required=false) Integer page) {//form으로 보냄
		try {
			HttpSession session = request.getSession();//세션에서 로그인 된 아이디를 가져옴->검색을 했는지 안했는지를 판별
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum());
			int currentPage = (page != null) ? page : 1;
			PageInfo pi = null;
			int totalCount = nService.getSearchCount(search);
			pi = Pagination.getPageInfo(currentPage, totalCount);
			
			
			List<Search> nList = nService.printSearchNotice(search, pi);
				
			mv.addObject("nList", nList);
			mv.addObject("search", search);
			mv.addObject("pi", pi);
			mv.setViewName("notice/noticeList");
			
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
}

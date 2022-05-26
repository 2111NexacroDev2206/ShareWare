package org.kh.shareware.notice.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.common.Search;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;
import com.nexacro17.xapi.data.DataSet;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService nService;

	// 넥사크로 리스트 보기
	@RequestMapping(value = "/admin/notice/nexaList.sw", method = RequestMethod.GET)
	public NexacroResult noticeListView() throws Exception {

		int nErrorCode = 0;
		String strErrorMsg = "START";
		NexacroResult result = new NexacroResult();

		List<Notice> nList = nService.adminlistNotice();

		if (!nList.isEmpty()) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = 1;
			strErrorMsg = "fail";
		}
		result.addDataSet("out_noticeList", nList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}

	// 넥사크로 리스트 검색
	@RequestMapping(value = "/admin/notice/searchList.sw", method = RequestMethod.POST)
	public NexacroResult adminNoticeSearchList(@ParamVariable(name = "searchCondition") String searchCondition // 콤보박스에
																												// 넣은 뭘로
																												// 검색할지
			, @ParamVariable(name = "searchValue") String searchValue) {
		// 에디트에 넣은 검색 값

		int nErrorCode = 0;
		String strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		Search search = new Search();
		search.setSearchCondition(searchCondition);
		search.setSearchValue(searchValue);

		List<Notice> nList = nService.noticeSearchList(search);

		if (!nList.isEmpty()) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "fail";
		}
		result.addDataSet("out_noticeList", nList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}

	// 넥사크로 상세보기
	@RequestMapping(value = "/admin/notice/detail.sw", method = RequestMethod.POST)
	public NexacroResult adminNoticeDetail(@ParamVariable(name = "noticeNo") int noticeNo) {
		// 에디트에 넣은 검색 값

		int nErrorCode = 0;
		String strErrorMsg = "START";
		NexacroResult result = new NexacroResult();

		Notice notice = nService.adminNoticeDetail(noticeNo);

		if (notice != null) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "fail";
		}
		result.addDataSet("out_noticeDetail", notice);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}

	// 넥사크로 글 작성
	@RequestMapping(value = "/admin/notice/register.sw", method = RequestMethod.POST)
	public NexacroResult registerNotice(HttpServletRequest request,
			@ParamDataSet(name = "notice") DataSet notice){
		int nErrorCode = 0;
		String strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		Notice newNotice = new Notice(); // 가져온 데이터셋 notice의 정보를 도메인에 넣어줌
		newNotice.setNoticeTitle(notice.getString(0, "noticeTitle"));
		newNotice.setNoticeContent(notice.getString(0, "noticeContent"));
		int nResult = nService.registerNotice(newNotice);

		if (nResult > 0) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "fail";
		}
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
	
	

	// 넥사크로 글 수정
	@RequestMapping(value = "/admin/notice/modify.sw", method = RequestMethod.POST)
	public NexacroResult modityNotice(
			HttpServletRequest request,
			@ParamDataSet(name = "notice") DataSet notice) throws Exception {
		int nErrorCode = 0;
		String strErrorMsg = "START";
		NexacroResult result = new NexacroResult();

		Notice newNotice = new Notice();// 가져온 데이터셋 notice의 정보를 도메인에 넣어줌
		newNotice.setNoticeNo(notice.getInt(0, "noticeNo"));
		newNotice.setNoticeTitle(notice.getString(0, "noticeTitle"));
		newNotice.setNoticeContent(notice.getString(0, "noticeContent"));

		int nResult = nService.modifyNotice(newNotice);

		if (nResult > 0) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = 1;
			strErrorMsg = "fail";
		}
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}

	// 넥사크로 글 삭제
	@RequestMapping(value = "/admin/notice/delete.sw")
	public NexacroResult adminMemberRemove(
			@ParamVariable(name = "noticeNo") int noticeNo) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		int rResult = nService.removeNotice(noticeNo);
		if(rResult > 0) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}

	// 리스트 보기
	@RequestMapping(value = "/notice/list.sw", method = RequestMethod.GET)
	public String noticeListView(Model model, @RequestParam(value = "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = nService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Notice> nList = nService.listNotice(pi);
		if (nList != null) {
			model.addAttribute("nList", nList);
			model.addAttribute("pi", pi);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("listCondition", "notice");
			model.addAttribute("myCondition", "board");
			return "notice/noticeList";
		} else {
			model.addAttribute("msg", "리스트 출력 실패");
			return "common/errorPage";
		}
	}

	// 디테일 페이지 보기
	@RequestMapping(value = "/notice/detail.sw", method = RequestMethod.GET)
	public String datailNotice(Model model, HttpServletRequest request, @RequestParam("noticeNo") Integer noticeNo) {
		// 조회수 증가
		nService.countViewNotice(noticeNo);

		// 게시글 번호로 검색
		Notice notice = nService.detailNotice(noticeNo);

		if (notice != null) {
			model.addAttribute("myCondition", "board");
			model.addAttribute("listCondition", "notice");
			model.addAttribute("notice", notice);
			return "notice/noticeDetail";
		} else {
			model.addAttribute("msg", "게시글 상세보기 실패");
			return "common/errorPage";
		}
	}

	// 검색
	@RequestMapping(value = "/notice/search.sw", method = RequestMethod.GET)
	public ModelAndView noticeSearchList(ModelAndView mv, @ModelAttribute Search search, HttpServletRequest request,
			@RequestParam(value = "page", required = false) Integer page) {// form으로 보냄
		try {
			HttpSession session = request.getSession();// 세션에서 로그인 된 아이디를 가져옴->검색을 했는지 안했는지를 판별
			search.setMemberNum(((Member) session.getAttribute("loginUser")).getMemberNum());
			int currentPage = (page != null) ? page : 1;
			PageInfo pi = null;
			int totalCount = nService.getSearchCount(search);
			pi = Pagination.getPageInfo(currentPage, totalCount);

			List<Search> nList = nService.printSearchNotice(search, pi);

			mv.addObject("nList", nList);
			mv.addObject("search", search);
			mv.addObject("pi", pi);
			mv.addObject("myCondition", "board");
			mv.addObject("listCondition", "notice");
			mv.setViewName("notice/noticeList");

		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	public String dsGet(DataSet ds, int rowno, String colid) throws Exception {
		String value;
		value = ds.getString(rowno, colid);
		if (value == null)
			return "";
		else
			return value;
	}
}

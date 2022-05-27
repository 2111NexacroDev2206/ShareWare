package org.kh.shareware.member.controller;

import java.util.ArrayList;
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
import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;
import com.nexacro17.xapi.data.DataSet;


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
			return "common/login";
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
		model.addAttribute("myCondition", "member");
		if(!mList.isEmpty()) {
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("mList", mList);
			model.addAttribute("pi", pi);
			return "member/addressView";
		}else {
			model.addAttribute("msg", "주소록 조회 실패");
			return "common/errorPage";
		}
	}
	//주소록 검색
	@RequestMapping(value="/member/searchList.sw", method=RequestMethod.GET)
	public String searchListView(
			Model model
			, HttpSession session
			, @RequestParam(value="page", required=false) Integer page
			, @ModelAttribute Search search) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = mService.getListCount(search);
		//int totalCount = mService.getListCountSearch(); //검색 페이징
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Member> mList = mService.printAllSearch(search, pi);
		if(!mList.isEmpty()) {
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("mList", mList);
			model.addAttribute("pi", pi);
			return "member/addressView";
		}else {
			model.addAttribute("msg", "주소록 검색 실패");
			return "common/errorPage";
		}
	}
	
	//조직도
	@RequestMapping(value="/member/organizationView.sw", method=RequestMethod.GET)
	public String organizationView(Model model){
		List<Division> oList = mService.printOrganization();
		model.addAttribute("myCondition", "organization");
		if(!oList.isEmpty()) {
			model.addAttribute("oList", oList);
			return "/member/organizationView";
		}else {
			model.addAttribute("msg", "조직도 조회 실패");
			return "common/errorPage";
		}
	}
	//조직도 json 데이터
	@ResponseBody
	@RequestMapping(value="/member/organizationData.sw", method=RequestMethod.GET)
	public String organizationJsonData(){
		List<Division> oList = mService.printOrganization();
		if(!oList.isEmpty()) {
			Gson gson = new Gson();
			return gson.toJson(oList); // [ {}, {}, .. ]
		}else {
			return null;
		}
	}
	//조직도 사원정보
	@ResponseBody
	@RequestMapping(value="/member/organizationInfo.sw", method=RequestMethod.GET)
	public String organizationInfo(
			Model model
			, @RequestParam("memNum") String memNum) {
		Member mOne = mService.printOneById(memNum);
		if(mOne != null) {
			//model.addAttribute("mOne", mOne);
			//return "/member/organizationView";
			Gson gson = new Gson();
			return gson.toJson(mOne);	// {}
		}else {
			//model.addAttribute("msg", "사원정보 조회 실패");
			//return "common/errorPage";
			return null;
		}
	}
	
	// 사원 목록(전자결재 결재자, 참조자 선택 모달창)
	@ResponseBody
	@RequestMapping(value = "/modal/member/list.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalMemberList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		List<Member> mList = mService.modalPrintAll(member.getMemberNum());
		if(!mList.isEmpty()) {
			return new Gson().toJson(mList);
		}
		return null;
	}
	
	// 사원 목록 검색(전자결재 결재자, 참조자 선택 모달창)
	@ResponseBody
	@RequestMapping(value = "/modal/member/search.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalMemberSearch(@ModelAttribute Search search, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		search.setMemberNum(member.getMemberNum());
		List<Member> mList = mService.modalPrintSearch(search);
		if(!mList.isEmpty()) {
			return new Gson().toJson(mList);
		}
		return null;
	}
	
	// 채팅 사용자 추가 초대 모달
	@ResponseBody
	@RequestMapping(value = "/modal/chat/inviteMember/list.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalChatInviteMemberList(@RequestParam("chatRoomNo") int chatRoomNo) {
		List<Member> mList = mService.modalChatInvitePrint(chatRoomNo);
		if(!mList.isEmpty()) {
			return new Gson().toJson(mList);
		}
		return null;
	}
	
	// 채팅 사용자 추가 초대 모달 검색
	@ResponseBody
	@RequestMapping(value = "/modal/chat/inviteMember/search.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalChatInviteMemberSearch(@ModelAttribute Search search) {
		List<Member> mList = mService.modalChatInviteSearch(search);
		if(!mList.isEmpty()) {
			return new Gson().toJson(mList);
		}
		return null;
	}
	
	// 넥사크로
	// 인사 관리 - 사원 관리 - 사원 목록 조회
	@RequestMapping(value = "admin/member/list.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberList(@ParamVariable(name = "inVar") String inVar) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		Search search = new Search();
		search.setSearchCondition(inVar);
		List<Member> mList = mService.printAllMember(search);
		if(!mList.isEmpty()) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addDataSet("out_member", mList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
	
	// 인사 관리 - 사원 관리 - 사원 목록 조회
	@RequestMapping(value = "admin/member/searchList.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberSearchList(@ParamVariable(name = "searchCondition") String searchCondition
			, @ParamVariable(name = "searchValue") String searchValue) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		Search search = new Search();
		search.setSearchCondition(searchCondition);
		search.setSearchValue(searchValue);
		List<Member> mList = mService.printAllMember(search);
		if(!mList.isEmpty()) {
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addDataSet("out_member", mList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
	
	// 인사 관리 - 사원 관리 - 사원 등록
	@RequestMapping(value = "admin/member/register.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberRegister(HttpServletRequest request, @ParamDataSet(name = "member") DataSet member) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		String photo = null;
		if(member.getString(0, "photo") != null) {
			photo = member.getString(0, "memberNum") + "." + member.getString(0, "photo").substring(member.getString(0, "photo").lastIndexOf(".") + 1);
		}
		// INSERT
		Member newMember = new Member(
				member.getString(0, "memberNum"),
				member.getString(0, "memberName"),
				null,
				member.getString(0, "division"),
				null,
				member.getString(0, "rank"),
				member.getString(0, "address"),
				member.getString(0, "phone"),
				member.getString(0, "mail"),
				member.getString(0, "hireDate"),
				member.getString(0, "retireDate"),
				member.getString(0, "birth"),
				member.getString(0, "account"),
				member.getString(0, "bank"),
				member.getString(0, "password"),
				member.getString(0, "gender"),
				photo,
				member.getString(0, "breakTotal"),
				null);
		int iResult = mService.registerMember(newMember);
		if(iResult > 0) {
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
	
	// 사원 상세 조회
	@RequestMapping(value = "admin/member/detail.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberDetail(@ParamVariable(name = "memberNum") String memberNum) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		Member member = mService.printOneMember(memberNum);
		if(member != null) {
			member.setPhoto("theme://images/" + member.getPhoto());
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addDataSet("out_member", member);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
	
	// 사원 삭제
	@RequestMapping(value = "admin/member/remove.sw")
	public NexacroResult adminMemberRemove(@ParamVariable(name = "memberNum") String memberNum) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		int rResult = mService.removeMember(memberNum);
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
	
	// 사원 정보 수정
	@RequestMapping(value = "admin/member/modify.sw", method = RequestMethod.POST)
	public NexacroResult adminMemberModify(HttpServletRequest request, @ParamDataSet(name = "member") DataSet member) {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		String photo = null;
		if(member.getString(0, "photo") != null) {
			photo = member.getString(0, "photo").substring(member.getString(0, "photo").lastIndexOf("\\") + 1);
		}
		// UPDATE
		Member newMember = new Member(
				member.getString(0, "memberNum"),
				member.getString(0, "memberName"),
				member.getString(0, "divCode"),
				null,
				member.getString(0, "rankCode"),
				null,
				member.getString(0, "address"),
				member.getString(0, "phone"),
				member.getString(0, "mail"),
				member.getString(0, "hireDate"),
				member.getString(0, "retireDate"),
				member.getString(0, "birth"),
				member.getString(0, "account"),
				member.getString(0, "bank"),
				member.getString(0, "password"),
				member.getString(0, "gender"),
				photo,
				member.getString(0, "breakTotal"),
				null);
		int iResult = mService.modifyMember(newMember);
		if(iResult > 0) {
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
	
	// 조직도
	@RequestMapping(value = "admin/member/organization.sw")
	public NexacroResult adminMemberorganization() {
		int 	nErrorCode = 0;
		String 	strErrorMsg = "START";
		NexacroResult result = new NexacroResult();
		List<Division> tList = new ArrayList<Division>();
		List<Division> dList = mService.printAllDivision();
		if(!dList.isEmpty()) {
			for(int i = 0; i < dList.size(); i++) {
				List<Division> mList = mService.printOneDivision(dList.get(i).getDivCode());
				tList.addAll(mList);
			}
		}
		if(!tList.isEmpty()) {
			for(int i = 0; i < tList.size(); i++) {
				if(tList.get(i).getDivLevel().equals("3")) {
					Member member = mService.printOneMember(tList.get(i).getDivCode());
					tList.get(i).setMemberName(member.getMemberName());
					tList.get(i).setRank(member.getRank());
					tList.get(i).setBirth(member.getBirth());
					tList.get(i).setMail(member.getMail());
					tList.get(i).setPhone(member.getPhone());
					tList.get(i).setAddress(member.getAddress());
					tList.get(i).setHireDate(member.getHireDate());
				}
			}
			nErrorCode = 0;
			strErrorMsg = "SUCC";
		} else {
			nErrorCode = -1;
			strErrorMsg = "Fail";
		}
		result.addDataSet("out_division", tList);
		result.addVariable("ErrorCode", nErrorCode);
		result.addVariable("ErrorMsg", strErrorMsg);
		return result;
	}
}
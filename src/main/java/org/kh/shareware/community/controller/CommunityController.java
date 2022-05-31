package org.kh.shareware.community.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.common.Search;
import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.community.domain.CommunityVoteSelect;
import org.kh.shareware.community.domain.Reply;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
//글작성 페이지 보기
	@RequestMapping(value="/community/WriteView.sw", method=RequestMethod.GET)
	public String CommunityWriteView(Model model) {
		model.addAttribute("myCondition", "board");
		model.addAttribute("listCondition", "community");
		return "community/communityWriteForm";
	}
	
	
	//글작성
	@ResponseBody
	@RequestMapping(value="/community/register.sw", method=RequestMethod.POST)
	public String registerCommunity(Model Model
			,HttpServletRequest request //session 에 저장 된 아이디를 가져와야함
			,@RequestParam(value="uploadFile", required=false) MultipartFile comImgName
			,@RequestParam("comContent")String comContent // @RequestParam으로 값을 가져와서 세팅해줘야함
			,@RequestParam("comTitle")String comTitle
			,@RequestParam(value="cVoteText1", required=false, defaultValue="")String cVoteText1
			,@RequestParam(value="cVoteText2", required=false, defaultValue="")String cVoteText2
			,@RequestParam(value="cVoteText3", required=false, defaultValue="")String cVoteText3
			,@RequestParam(value="cVoteText4", required=false, defaultValue="")String cVoteText4){
	
			HttpSession session = request.getSession();
			String memberNum = "";
			Member member = (Member)session.getAttribute("loginUser");
			if(member != null) {
				memberNum = member.getMemberNum();
			}else {
				memberNum = "admin";
			}
			
			Community community = new Community();
			CommunityVote communityVote = new CommunityVote();
			
			community.setMemberNum(memberNum);//값넣어주기
			community.setComTitle(comTitle);
			community.setComContent(comContent);
			
			
			if(comImgName != null && !comImgName.getOriginalFilename().equals("")) {
				HashMap<String, String> fileMap = saveFile(comImgName, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName"); //바꾼 이름을 가져옴
				if(filePath != null && !filePath.equals("")) {
					community.setComImgName(comImgName.getOriginalFilename()); 
					community.setComImgRename(fileRename); //가져온 값을 넣어줌
					community.setComImgPath(filePath);
				}
			}
			
			int result = cService.registerCommunity(community);
			
			if(!cVoteText1.equals("")) {
				//글 번호를 가져오는 select 로직을 가셔와서 사용
				int comNo = cService.searchComNo();
				
				//여기에 대신 넣어줌

				communityVote.setComNo(comNo);
				communityVote.setcVoteText1(cVoteText1);
				communityVote.setcVoteText2(cVoteText2);
				communityVote.setcVoteText3(cVoteText3);
				communityVote.setcVoteText4(cVoteText4);
				
				cService.registerCommunityVote(communityVote);
			}
			
			if(result>0) {
				return "success";
			}else {
				return "fail";
			}
	}
	
		//리스트 페이지 보기
		@RequestMapping(value="/community/list.sw", method=RequestMethod.GET)
		public String CommunityListView(
				Model model
				,@RequestParam(value="page", required=false) Integer page
				,HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			String memberNum = "";
			Member member = (Member)session.getAttribute("loginUser");
			memberNum = member.getMemberNum();
			
			Community community = new Community();
			community.setMemberNum(memberNum);
			
			int currentPage = (page != null) ? page : 1;
			//DB에서 전체 게시물의 갯수
			int totalCount = cService.getListCount(memberNum);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
			List<Community> cList = cService.listCommunity(pi, memberNum);
			
			if(cList != null) {
				model.addAttribute("cList", cList);
				model.addAttribute("pi", pi);
				model.addAttribute("myCondition", "board");
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("totalCount", totalCount);
				model.addAttribute("listCondition", "community");
				return "community/communityList";
			}else {
				model.addAttribute("msg", "리스트 출력 실패");
				return "common/errorPage";
			}
		}
	
		
		
//디테일 페이지 보기
	@RequestMapping(value="/community/detail.sw", method=RequestMethod.GET)
	public String datailCommunity(
			Model model
			,HttpServletRequest request
			,@RequestParam("comNo") Integer comNo) {
		//조회수 증가
		cService.countViewCommunity(comNo);
	
		
		//게시글 번호로 검색
		Community community = cService.detailCommunity(comNo);

		
		if(community != null) {
			model.addAttribute("myCondition", "board");
			model.addAttribute("listCondition", "community");
			model.addAttribute("community",community);
			return "community/communityDetail";
		}else {
			model.addAttribute("msg", "게시글 상세보기 실패");
			return "common/errorPage";
		}
	}
	

	
	//글 수정 페이지 보기
	@RequestMapping(value="/community/modifyView.sw", method=RequestMethod.GET)
	public String CommunityModifyView(
			Model model
			,@RequestParam("comNo") int comNo) {
	
		
		//게시글 번호로 검색
		Community community = cService.detailCommunity(comNo);
		//투표 번호 검색
		CommunityVote communityVote = cService.detailCommunityVote(comNo);
		//사용자 번호로 사용자 투표테이블 가져오기
		CommunityVoteSelect cVoteSelect = cService.viewCommunityVote(comNo);
		
		if(community != null) {
			model.addAttribute("myCondition", "board");
			model.addAttribute("listCondition", "community");
			model.addAttribute("community",community);
			model.addAttribute("communityVote",communityVote);
			model.addAttribute("cVoteSelect",cVoteSelect);
			return "community/communityModifyForm";
		}else {
			model.addAttribute("msg", "게시글 상세보기 실패");
			return "common/errorPage";
		}	
	}
	
	//글 수정
	@ResponseBody
	@RequestMapping(value="/community/modify.sw", method=RequestMethod.POST)
	public String modifyCommunity(
			Model model
			,HttpServletRequest request
			,@RequestParam(value="uploadFile", required=false) MultipartFile comImgName
			,@RequestParam("comNo")int comNo
			,@RequestParam("comContent")String comContent // @RequestParam으로 값을 가져와서 세팅해줘야함
			,@RequestParam("comTitle")String comTitle
			,@RequestParam(value="cVoteText1", required=false, defaultValue="")String cVoteText1
			,@RequestParam(value="cVoteText2", required=false, defaultValue="")String cVoteText2
			,@RequestParam(value="cVoteText3", required=false, defaultValue="")String cVoteText3
			,@RequestParam(value="cVoteText4", required=false, defaultValue="")String cVoteText4
			,@RequestParam(value="cVoteState")Integer cVoteState) {
	
		
	
		
		Community community = new Community();
		CommunityVote communityVote = new CommunityVote();
		
		community.setComNo(comNo);
		community.setComTitle(comTitle);//값넣어주기
		community.setComContent(comContent);
		
		if(comImgName != null && !comImgName.getOriginalFilename().equals("")) {
			HashMap<String, String> fileMap = saveFile(comImgName, request);
			String filePath = fileMap.get("filePath");
			String fileRename = fileMap.get("fileName"); //바꾼 이름을 가져옴
			if(filePath != null && !filePath.equals("")) {
				community.setComImgName(comImgName.getOriginalFilename()); 
				community.setComImgRename(fileRename); //가져온 값을 넣어줌
				community.setComImgPath(filePath);
			}
		}
		
		int result = cService.modifyCommunity(community);
		
		communityVote.setComNo(comNo);
		communityVote.setcVoteText1(cVoteText1);
		communityVote.setcVoteText2(cVoteText2);
		communityVote.setcVoteText3(cVoteText3);
		communityVote.setcVoteText4(cVoteText4);
		
		
		
		if(cVoteState != null && cVoteState == 0) {//만약 등록 되어있는 투표를 수정할 경우
			
			cService.modifyCommunityVote(communityVote);
		}
		
		if(!cVoteText1.equals("") && cVoteState == null) {
			//투표가 등록되어있지 않은 게시판에 투표를 새로 추가할 경우
			cService.registerCommunityVote(communityVote);
		}
		
		
		
		
		
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	

	
	//글삭제
	@ResponseBody
	@RequestMapping(value="/community/deleteCommunity.sw", method=RequestMethod.GET)
	public String removeCommunity(
		@RequestParam("comNo") Integer comNo
		,@RequestParam("comVoteNo") Integer comVoteNo
		,@RequestParam("cSelect") Integer cSelect
		,@RequestParam("replyCount") Integer replyCount) {

	
			cService.removeReplyAll(comNo);
			cService.removeCVoteMember(comNo);
			cService.removeCommunityVote(comNo);
	
		
		int result =cService.removeCommunity(comNo);
		if(result >0) {
			return "success";
		}
		return "fail";
	}
	
	//투표 	
	@ResponseBody
	@RequestMapping(value="/community/insertCommunityVote.sw", method=RequestMethod.GET)
	public String registerCommunityVote(
		@RequestParam("comNo") int comNo
		,@RequestParam("comVoteNo") int comVoteNo
		,@RequestParam("cSelect") int cSelect
		,@RequestParam("memberNum") String memberNum) {
				//CommunityVoteSelect 는 insert
				//CommunityVote는 update
			
		Map<String, Object> map = new HashMap<>();
			map.put("cSelect",cSelect);
			map.put("comNo",comNo);
			
			CommunityVoteSelect cVoteSelect = new CommunityVoteSelect();
				cVoteSelect.setMemberNum(memberNum);
				cVoteSelect.setComVoteNo(comVoteNo);
				cVoteSelect.setComNo(comNo);
				cVoteSelect.setcSelect(cSelect);

					
				int selectResult = cService.registerCVoteSelect(cVoteSelect);
				int updateReulst = cService.countCVoteSelect(map);
			if(selectResult >0 && updateReulst>0) {
				return "success";
			}
			return "fail";
		}
	
	//투표 보기
	@ResponseBody
	@RequestMapping(value="/community/viewCommunityVote.sw", method=RequestMethod.GET)
		public void viewCommunityVote(
		@RequestParam("comNo") int  comNo
		,HttpServletResponse response) throws Exception{{
							
		//투표 검색				
		CommunityVote Result = cService.detailCommunityVote(comNo);
		//투표한 사람 검색
		CommunityVoteSelect mResult = cService.viewCommunityVote(comNo);
		
		if(Result != null) {
			if(mResult == null) {
				CommunityVoteSelect cSelect = new CommunityVoteSelect();
				cSelect.setcSelectTrue(0);
				HashMap<Object, Object> map = new HashMap<>();
				map.put("communityVote",Result);
				map.put("cVoteSelect",cSelect);
				Gson gson = new Gson();
				gson.toJson(map, response.getWriter());
				
				}else {
					// 성공했을 때
					HashMap<Object, Object> map = new HashMap<>();
					map.put("communityVote",Result);
					map.put("cVoteSelect",mResult);
					Gson gson = new Gson();
					gson.toJson(map, response.getWriter());
				}	
		}
			
		}
	}

	//투표 종료
	@ResponseBody
	@RequestMapping(value="/community/endVoteCommunity.sw", method=RequestMethod.GET)
			public String andVoteCommunity(
				@RequestParam("comNo") Integer comNo) {
						
					
						int Result = cService.endCommunityVote(comNo);
						
						
					if(Result >0) {
						return "success";
					}
					return "fail";
				}

	
	//투표 삭제
	@ResponseBody
	@RequestMapping(value="/community/deleteCommuntyVote.sw", method=RequestMethod.GET)
		public String removeCommunityVote(
			@RequestParam("comNo") Integer comNo
			,@RequestParam("cSelect") Integer cSelect) {
				if(cSelect!= null) {
					cService.removeCVoteMember(comNo);
				}
				int result = cService.removeCommunityVote(comNo);
			
			if(result >0) {
				return "success";
			}
			return "fail";
		}
	
	//댓글 리스트 출력
	@RequestMapping(value="/community/replyList.sw", method=RequestMethod.GET)
	public void listReply(
				@RequestParam("comNo") int  comNo
				,HttpServletResponse response) throws Exception{
		
		List<Reply> cReplyList = cService.printAllCommunityReply(comNo);
		if(!cReplyList.isEmpty()) {
			// 성공했을 때
			//Gson gson = new Gson();
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cReplyList, response.getWriter()); // List를 json로 바꿈
		}
	}
	
	//댓글 등록
	@ResponseBody
	@RequestMapping(value="/community/replyAdd.sw", method=RequestMethod.POST)
		public String registerReply (
			HttpServletRequest request
			,@ModelAttribute Reply Reply) {
		
			HttpSession session = request.getSession();
			String memberNum = "";
			Member member = (Member)session.getAttribute("loginUser");
				memberNum = member.getMemberNum();
				Reply.setMemberNum(memberNum);
					
			int result = cService.registerReply(Reply);
		
			if(result >0) {
				return "success";
			}
			return "fail";
		}
	
	//댓글 수정
		@ResponseBody
		@RequestMapping(value="/community/modifyReply.sw", method=RequestMethod.POST)
			public String modifyReply (
				@ModelAttribute Reply Reply) {
						
				int result = cService.modifyReply(Reply);
			
				if(result >0) {
					return "success";
				}
				return "fail";
			}
	
	
	
	//댓글 삭제
		@ResponseBody
		@RequestMapping(value="/community/deleteReply.sw", method=RequestMethod.GET)
			public String deleteReply (
				@ModelAttribute Reply Reply) {
			
				int result = cService.deleteReply(Reply);
			
				if(result >0) {
					return "success";
				}
				return "fail";
			}
	
	//검색
	@RequestMapping(value="/community/search.sw", method=RequestMethod.GET)
	public ModelAndView communitySearchList(
			ModelAndView mv
			, @ModelAttribute Search search
			, HttpServletRequest request
			,@RequestParam(value="page", required=false) Integer page) {//form으로 보냄
		try {
			HttpSession session = request.getSession();//세션에서 로그인 된 아이디를 가져옴->검색을 했는지 안했는지를 판별
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum());
			String memberNum = "";
			Member member = (Member)session.getAttribute("loginUser");
			memberNum = member.getMemberNum();
			
			search.setMemberNum(memberNum);
			
			int currentPage = (page != null) ? page : 1;
			PageInfo pi = null;
			int totalCount = cService.getSearchCount(search);
			pi = Pagination.getPageInfo(currentPage, totalCount);
			
			
			List<Search> cList = cService.printSearchCommunity(pi,search);
				
			mv.addObject("cList", cList);
			mv.addObject("search", search);
			mv.addObject("currentPage",currentPage);
			mv.addObject("totalCount",totalCount);
			mv.addObject("pi", pi);
			mv.setViewName("community/communityList");
			
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
		
	public HashMap<String, String> saveFile(MultipartFile file, HttpServletRequest request) {
		String filePath = "";
		HashMap<String, String> fileMap = new HashMap<String, String>();
		//HashMap 선언
		
		// 파일 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		// 저장 폴더 선택
		String savePath = root + "\\loadFile";
		// 없으면 생성
		File folder = new File(savePath);
		if(!folder.exists()) folder.mkdir();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		// 업로드한 파일명
		String originalFileName = file.getOriginalFilename();
		// 파일 확장자명
		String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		// 변경할 파일명, 변경할 때에는 SimpleDateFormat 객체를 이용해서
		// 시간을 파일의 이름으로 바꿔줌
		String renameFileName 
			= sdf.format(new Date(System.currentTimeMillis()))+"."+extensionName;
		filePath = folder + "\\" + renameFileName;
		// 두가지 값을 map에 저장하여 리턴하기
		fileMap.put("filePath", filePath);
		fileMap.put("fileName", renameFileName); 
		// 파일 저장
		try {
			file.transferTo(new File(filePath)); // 파일 저장됨
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 파일경로 리턴
		return fileMap;
	}
}

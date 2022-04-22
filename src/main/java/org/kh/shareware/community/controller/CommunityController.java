package org.kh.shareware.community.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CommunityController {

	@Autowired
	private CommunityService cService;
	
//글작성 페이지 보기
	@RequestMapping(value="/community/WriteView.sw", method=RequestMethod.GET)
	public String CommunityWriteView() {
		return "community/communityWriteForm";
	}
	
	
	//글작성
	@ResponseBody
	@RequestMapping(value="/community/register.sw", method=RequestMethod.POST)
	public String resisterCommunity(Model Model
			,HttpServletRequest request //session 에 저장 된 아이디를 가져와야함
			,@RequestParam(value="uploadFile", required=false) MultipartFile comImgName
			,@RequestParam("comContent")String comContent // 객체로 전달했기 때문에 @RequestParam으로 값을 가져와서 셋팅해줘야함
			,@RequestParam("comTitle")String comTitle ){
	
			HttpSession session = request.getSession();
			String memberNum = ((Member)session.getAttribute("loginUser")).getMemberNum();
			
			Community community = new Community();
			
			community.setMemberNum(memberNum);//값넣어주기
			community.setComTitle(comContent);
			community.setComContent(comTitle);
			
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
			int result = cService.resisterCommunity(community);
			if(result>0) {
				return "success";
			}else {
				return "fail";
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

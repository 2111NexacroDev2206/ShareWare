package org.kh.shareware.fileBoard.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.fileBoard.domain.FileBoard;
import org.kh.shareware.fileBoard.service.FileBoardService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileBoardController {
	
	@Autowired
	private FileBoardService fService;
 
//글작성 페이지 보기
	@RequestMapping(value="/fileBoard/WriteView.sw", method=RequestMethod.GET)
	public String fileBoardWriteView() {
		return "fileBoard/fileBoardWriteForm";
	}
 
//글작성
	@ResponseBody
	@RequestMapping(value="/fileBoard/register.sw", method=RequestMethod.POST)
	public String registerCommunity(
			HttpServletRequest request //session 에 저장 된 아이디를 가져와야함
			,@RequestParam(value="uploadFile", required=false) MultipartFile fileName
			,@RequestParam("fileContent")String fileContent // @RequestParam으로 값을 가져와서 세팅해줘야함
			,@RequestParam("fileTitle")String fileTitle){
	
			HttpSession session = request.getSession();
			String memberNum = "";
			Member member = (Member)session.getAttribute("loginUser");
				memberNum = member.getMemberNum();
			
			FileBoard fileBoard = new FileBoard();
			fileBoard.setMemberNum(memberNum);//값넣어주기
			fileBoard.setFileBoardTitle(fileTitle);
			fileBoard.setFileBoaedContent(fileContent);
			
			
			if(fileName != null && !fileName.getOriginalFilename().equals("")) {
				HashMap<String, String> fileMap = saveFile(fileName, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
				if(filePath != null && !filePath.equals("")) {
					fileBoard.setFileName(fileName.getOriginalFilename()); 
					fileBoard.setFileRename(fileRename); 
					fileBoard.setFilePath(filePath);
				}
			}
			
			int result = fService.registerFileBoard(fileBoard);
			
			if(result>0) {
				return "success";
			}else {
				return "fail";
			}
	}
	
	//리스트 페이지 보기
	@RequestMapping(value="/fileBoard/list.sw", method=RequestMethod.GET)
	public String fileBoardListView(
			Model model
			,@RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		//DB에서 전체 게시물의 갯수
		int totalCount = fService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<FileBoard> fList = fService.listFileBoard(pi);
		if(fList != null) {
			model.addAttribute("fList", fList);
			model.addAttribute("pi", pi);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("listCondition", "fileBoard");
			model.addAttribute("myCondition", "board");
			return "fileBoard/fileBoardList";
		}else {
			model.addAttribute("msg", "리스트 출력 실패");
			return "common/errorPage";
		}
	}
	
	//디테일 페이지 보기
		@RequestMapping(value="/fileBoard/detail.sw", method=RequestMethod.GET)
		public String datailCommunity(
				Model model
				,HttpServletRequest request
				,@RequestParam("fileBoardNo") Integer fileBoardNo) {
			//조회수 증가
			fService.viewCountFileBoard(fileBoardNo);
		
			
			//게시글 번호로 검색
			FileBoard fileBoard = fService.detailFileBoard(fileBoardNo);

			
			if(fileBoard != null) {
				model.addAttribute("myCondition", "board");
				model.addAttribute("fileBoard",fileBoard);
				return "fileBoard/fileBoardDetail";
			}else {
				model.addAttribute("msg", "게시글 상세보기 실패");
				return "common/errorPage";
			}
		}
		
		//글 수정 페이지 보기
		@RequestMapping(value="/fileBoard/modifyView.sw", method=RequestMethod.GET)
		public String fileBoardyModifyView(
				Model model
				,@RequestParam("fileBoardNo") int fileBoardNo) {
			
			//게시글 번호로 검색
			FileBoard fileBoard = fService.detailFileBoard(fileBoardNo);
			
			if(fileBoard != null) {
				model.addAttribute("myCondition", "board");
				model.addAttribute("fileBoard",fileBoard);
				return "fileBoard/fileBoardModifyForm";
			}else {
				model.addAttribute("msg", "게시글 상세보기 실패");
				return "common/errorPage";
			}	
		}
		
		//글 수정
		@ResponseBody
		@RequestMapping(value="/fileBoard/modify.sw", method=RequestMethod.POST)
		public String fileBoardModify(
				@RequestParam(value="uploadFile", required=false) MultipartFile fileName
			   ,@RequestParam("fileBoardNo") int fileBoardNo
			   ,@RequestParam("fileBoaedContent") String fileBoaedContent
			   ,@RequestParam("fileBoardTitle") String fileBoardTitle
			   ,HttpServletRequest request) {
			
			FileBoard fileBoard = new FileBoard();
			fileBoard.setFileBoardNo(fileBoardNo);
			fileBoard.setFileBoardTitle(fileBoardTitle);
			fileBoard.setFileBoaedContent(fileBoaedContent);
			
			
			if(fileName != null && !fileName.getOriginalFilename().equals("")) {
				HashMap<String, String> fileMap = saveFile(fileName, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
				if(filePath != null && !filePath.equals("")) {
					fileBoard.setFileName(fileName.getOriginalFilename()); 
					fileBoard.setFileRename(fileRename); 
					fileBoard.setFilePath(filePath);
				}
			}
					
			
			int result = fService.modifyFileBoard(fileBoard);
					
			if(result > 0) {
				return "success";
			}else {
				return "fail";
			}
		}
	
		//글 삭제
		@ResponseBody
		@RequestMapping(value="/fileBoard/deletefile.sw", method=RequestMethod.GET)
		public String deletefile(
				Model model
				,HttpServletRequest request
				,@RequestParam("fileBoardNo") Integer fileBoardNo) {
			
			int reulst = fService.deleteFile(fileBoardNo);
					
			if(reulst > 0) {
				return "success";
			}else {
				return "fail";
			}
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

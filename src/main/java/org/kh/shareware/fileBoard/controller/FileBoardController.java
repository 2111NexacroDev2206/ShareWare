package org.kh.shareware.fileBoard.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.community.domain.Community;
import org.kh.shareware.community.domain.CommunityVote;
import org.kh.shareware.fileBoard.domain.FileBoard;
import org.kh.shareware.fileBoard.service.FileBoardService;
import org.kh.shareware.member.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileBoardController {
 private FileBoardService fService;
 
//글작성 페이지 보기
	@RequestMapping(value="/fileBoard/WriteView.sw", method=RequestMethod.GET)
	public String fileBoardWriteView() {
		return "fileBoard/fileBoardWriteForm";
	}
 
//글작성
	@ResponseBody
	@RequestMapping(value="/fileBoard/register.sw", method=RequestMethod.POST)
	public String registerCommunity(Model Model
			,HttpServletRequest request //session 에 저장 된 아이디를 가져와야함
			,@RequestParam(value="uploadFile", required=false) MultipartFile comImgName
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
			
			
			if(comImgName != null && !comImgName.getOriginalFilename().equals("")) {
				HashMap<String, String> fileMap = saveFile(comImgName, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName"); //바꾼 이름을 가져옴
				if(filePath != null && !filePath.equals("")) {
					fileBoard.setFileName(comImgName.getOriginalFilename()); 
					fileBoard.setFileRename(fileRename); //가져온 값을 넣어줌
					fileBoard.setFilePath(filePath);
				}
			}
			
			int result = fService.registerCommunity(fileBoard);
			
			if(result>0) {
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

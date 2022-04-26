package org.kh.shareware.report.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.report.domain.Daily;
import org.kh.shareware.report.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DailyController {

	@Autowired
	private DailyService service;
	
	//일일 업무 목록
	@RequestMapping(value="/report/dailyList.sw", method = RequestMethod.GET)
	public ModelAndView dailyListView(Model model, ModelAndView mv) {
		//model.addAttribute("myCondition", "report");
		model.addAttribute("listCondition", "dailyList");
		try {
			List<Daily> dList = service.printAllDaily();
			if(!dList.isEmpty()) {
				mv.addObject("dList", dList);
				mv.setViewName("report/dailyList");
			}else {
				mv.addObject("msg", "업무일지 조회 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	//일일 업무 등록 화면 
	@RequestMapping(value="/report/dailyWriteView.sw")
	public String dailyWriteView(Model model) {
		model.addAttribute("listCondition", "dailyWrite");
		Date nowTime = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    model.addAttribute("nowTime", sf.format(nowTime));
		return "report/dailyWriteForm";
	}
	
	//일일 업무 등록 
	@RequestMapping(value="/report/dailyRegister.sw", method=RequestMethod.POST)
	public ModelAndView dailyRegister(ModelAndView mv
			,@ModelAttribute Daily daily
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,HttpServletRequest request
			,Model model){
		model.addAttribute("listCondition", "dailyWrite");
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				HashMap<String, String> fileMap = saveFile(uploadFile, request); // 업로드한 파일 저장하고 경로 리턴
				String filePath = fileMap.get("filePath");
				String fileReName = fileMap.get("fileName");
				if(filePath != null && !filePath.equals("")) {
					daily.setFileName(uploadFile.getOriginalFilename());
					daily.setFileReName(fileReName);
					daily.setFilePath(filePath);
				}
			}
			int result = service.registerDaily(daily);
			if(result > 0) {
				mv.setViewName("redirect:/report/dailyList.sw");
			}else {
				mv.addObject("msg", "업무일지 등록 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e) {
			mv.setViewName("common/errorPage");
			mv.addObject("msg", e.toString());
		}
		return mv;
	}
	
	private HashMap<String, String> saveFile(MultipartFile file, HttpServletRequest request) {
		String filePath = "";
		HashMap<String, String> fileMap = new HashMap<String, String>();
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\duploadFiles";
		File folder = new File(savePath);
		if(!folder.exists()) folder.mkdir();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		String renameFileName 
			= sdf.format(new Date(System.currentTimeMillis()))+"."+extensionName;
		filePath = folder + "\\" + renameFileName;
		fileMap.put("filePath", filePath);
		fileMap.put("fileName", renameFileName); 
		try {
			file.transferTo(new File(filePath)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileMap;
	}
	//일일 업무 상세화면 
	 @RequestMapping(value="/report/dailyDetail.sw", method=RequestMethod.GET)
	   public ModelAndView dailyDetailView(
			   ModelAndView mv
				, @RequestParam(value = "drNo", required =false) Integer drNo) {
	try {
		Daily daily = service.printOneByNo(drNo);
		if(daily != null) {
			mv.addObject("daily", daily);
			mv.setViewName("report/dailyDetail");
		}else {
			mv.addObject("msg", "업무일지 상세조회 실패");
			mv.setViewName("common/errorPage");
		}
	}catch(Exception e) {
		mv.addObject("msg", e.toString());
		mv.setViewName("common/errorPage");
	}
	return mv;
	 }
	//일일 업무 수정 화면 
	 @RequestMapping(value="/report/dailyModifyView.sw", method=RequestMethod.GET)
		public String dailyModifyView(
				  Model model
				, @RequestParam(value = "drNo", required =false) Integer drNo) {
			try {
				// 수정화면에 필요한 데이터 DB 가져오기
				Daily daily = service.printOneByNo(drNo);
				if(daily != null) {
					model.addAttribute("daily", daily);
					return "report/dailyUpdateView";
				}else {
					// 데이터가 없을 때 메시지 출력
					model.addAttribute("msg", "No Data Found!!");
					return "common/errorPage";
				}
			}catch(Exception e) {
				model.addAttribute("msg", e.toString());
				return "common/errorPage";
			}
			
		}
	 //일일 업무 수정
	 @RequestMapping(value="/report/dailyUpdate.sw", method=RequestMethod.POST)
		public ModelAndView dailyUpdate(
				ModelAndView mv
				, @ModelAttribute Daily daily
				// 400 오류 방지
				, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
				, HttpServletRequest request) {
			try {
				// 프로젝트 경로에 파일수정(reloadFile, request), 삭제하고 다시 업로드
				if(reloadFile != null && !reloadFile.isEmpty()) {
					// 기존 파일 삭제 하고
					// (기존 파일 삭제할 때는 파일이름 필요!)
					deleteFile(daily.getFilePath(), request);
					// 새로운 파일 업로드
					HashMap<String, String> fileMap = saveFile(reloadFile, request); // 새롭게 저장
					String savePath = fileMap.get("filePath");
					String fileReName = fileMap.get("fileName");
					if(savePath != null) {
						daily.setFileName(reloadFile.getOriginalFilename());
						daily.setFileReName(fileReName);
						daily.setFilePath(savePath); // 새로운 경로로 업데이트 하기 위해서
					}
				}
				// 디비에 해당 데이터 저장(비즈니스 로직)
				int result = service.modifyDaily(daily);
				if(result > 0) {
					mv.setViewName("report/dailyDetail");
				}else {
					mv.addObject("msg", "업무일지 수정실패");
					mv.setViewName("common/errorPage");
				}
			} catch(Exception e) {
				mv.addObject("msg", e.toString());
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
	 
	private void deleteFile(String filePath, HttpServletRequest request) {
		File deleteFile = new File(filePath);
		if(deleteFile.exists()) { // 파일이 존재하면
			// 파일 삭제
			deleteFile.delete();
		}
	}
	//일일 업무 삭제 
	 @RequestMapping(value="/report/dailyDelete.sw", method=RequestMethod.GET)
	 public String dailyDelete(
			 Model model
			 , @RequestParam("drNo") int drNo) {
		 try {
			 int result = service.removeDaily(drNo);
			 if(result > 0) {
				 return "redirect:/report/dailyList.sw";
			 }else
				 model.addAttribute("msg", "업무일지 삭제 실패");
			 	 return "common/errorPage";
		 }catch(Exception e) {
				 model.addAttribute("msg", e.toString());
				 return("common/errorPage");
			}
}
	 
	 //첨부파일 삭제
	 @RequestMapping(value="/report/dailyFileDelete.sw", method=RequestMethod.GET )
	 public String fileDelete(ModelAndView mv
				// 400 오류 방지
				, @RequestParam(value="filePath", required=false) String filePath 
				,@RequestParam(value = "drNo", required =false) Integer drNo 
				, HttpServletRequest request  ){
		 
					// 프로젝트 경로에 파일수정(reloadFile, request), 삭제하고 다시 업로드
						deleteFile(filePath, request);
				int result = service.removeFileInfo(drNo);
				return "redirect:/report/dailyList.sw";
		 
	 }
			 
}
	


	

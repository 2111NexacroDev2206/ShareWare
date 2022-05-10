package org.kh.shareware.report.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.common.Pagination;
import org.kh.shareware.report.domain.Daily;
import org.kh.shareware.report.domain.Week;
import org.kh.shareware.report.service.DailyService;
import org.kh.shareware.report.service.WeekService;
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
public class WeekController {
	
	@Autowired
	private WeekService service;
	
	//주간 업무 목록
	@RequestMapping(value="/report/weekList.sw", method = RequestMethod.GET)
	public ModelAndView weekListView(ModelAndView mv
			, HttpServletRequest request
			,@RequestParam(value="page", required=false) Integer page) {
			
		HttpSession session = request.getSession();
		String memNum = ((Member)(session.getAttribute("loginUser"))).getMemberNum();
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(memNum);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		try {
			List<Week> wList = service.printAllWeek(memNum, pi);
			mv.addObject("wList", wList);
			mv.addObject("pi", pi);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("report/weekList");
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	//주간 업무 등록 화면 
		@RequestMapping(value="/report/weekWriteView.sw")
		public String weekWriteView(Model model) {
			Date nowTime = new Date();
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		    model.addAttribute("nowTime", sf.format(nowTime));
			return "report/weekWriteForm";
		}
		
		//주간 업무 등록 
		@RequestMapping(value="/report/weekRegister.sw", method=RequestMethod.POST)
		public ModelAndView weekRegister(ModelAndView mv
				,@ModelAttribute Week week
				,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
				,HttpServletRequest request
				,Model model){
			try {
				if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
					HashMap<String, String> fileMap = saveFile(uploadFile, request); // 업로드한 파일 저장하고 경로 리턴
					String filePath = fileMap.get("filePath");
					String fileReName = fileMap.get("fileName");
					if(filePath != null && !filePath.equals("")) {
						week.setFileName(uploadFile.getOriginalFilename());
						week.setFileReName(fileReName);
						week.setFilePath(filePath);
					}
				}
				int result = service.registerWeek(week);
				if(result > 0) {
					mv.setViewName("redirect:/report/weekList.sw");
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
			String savePath = root + "\\wuploadFiles";
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
		
		//주간 업무 상세화면 
		 @RequestMapping(value="/report/weekDetail.sw", method=RequestMethod.GET)
		   public ModelAndView weekDetailView(
				   ModelAndView mv
					, @RequestParam(value = "wrNo", required =false) Integer wrNo) {
		try {
			Week week = service.printOneByNo(wrNo);
			if(week != null) {
				mv.addObject("week", week);
				mv.setViewName("report/weekDetail");
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
		//주간업무 수정 화면 
		 @RequestMapping(value="/report/weekModifyView.sw", method=RequestMethod.GET)
			public String weekModifyView(
					  Model model
					, @RequestParam(value = "wrNo", required =false) Integer wrNo) {
				try {
					// 수정화면에 필요한 데이터 DB 가져오기
					Week week = service.printOneByNo(wrNo);
					if(week != null) {
						model.addAttribute("week", week);
						return "report/weekUpdateView";
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
		 
		 //주간 업무 수정 
		 @RequestMapping(value="/report/weekUpdate.sw", method=RequestMethod.POST)
			public ModelAndView weekUpdate(
					ModelAndView mv
					, @ModelAttribute Week week
					, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
					, HttpServletRequest request) {
				try {
					if(reloadFile != null && !reloadFile.isEmpty()) {
						deleteFile(week.getFilePath(), request);
						HashMap<String, String> fileMap = saveFile(reloadFile, request); // 새롭게 저장
						String savePath = fileMap.get("filePath");
						String fileReName = fileMap.get("fileName");
						if(savePath != null) {
							week.setFileName(reloadFile.getOriginalFilename());
							week.setFileReName(fileReName);
							week.setFilePath(savePath); // 새로운 경로로 업데이트 하기 위해서
						}
					}
					int result = service.modifyWeek(week);
					if(result > 0) {
						mv.setViewName("report/weekDetail");
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
		//주간업무 삭제
		 @RequestMapping(value="/report/weekDelete.sw", method=RequestMethod.GET)
		 public String weekDelete(
				 Model model
				 , @RequestParam("wrNo") int wrNo) {
			 try {
				 int result = service.removeWeek(wrNo);
				 if(result > 0) {
					 return "redirect:/report/weekList.sw";
				 }else
					 model.addAttribute("msg", "업무일지 삭제 실패");
				 	 return "common/errorPage";
			 }catch(Exception e) {
					 model.addAttribute("msg", e.toString());
					 return("common/errorPage");
				}
	}
		 //첨부파일 삭제
		 @RequestMapping(value="/report/weekFileDelete.sw", method=RequestMethod.GET)
		 public String fileDelete(ModelAndView mv
					, @RequestParam(value="filePath", required=false) String filePath 
					,@RequestParam(value = "wrNo", required =false) Integer wrNo 
					, HttpServletRequest request  ){
						deleteFile(filePath, request);
					int result = service.removeFileInfo(wrNo);
					return "redirect:/report/weekModifyView.sw?wrNo="+wrNo;
			 
		 }
		
}

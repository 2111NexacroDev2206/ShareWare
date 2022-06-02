package org.kh.shareware.project.controller;

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
import org.kh.shareware.project.domain.Work;
import org.kh.shareware.project.service.WorkService;
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
public class WorkController {@Autowired
	private WorkService service;
	
	//업무현황 목록
	@RequestMapping(value="/project/workList.sw", method= RequestMethod.GET)
	public String workListView(Model model
			, HttpServletRequest request
			,@ModelAttribute Work work
			,@RequestParam(value="projectNo", required=false) Integer projectNo
			,@RequestParam(value="page", required=false) Integer page
			,@RequestParam(value="status", required=false) String status) {
		if(status == null) {
			status = "all";
		}
		model.addAttribute("myCondition", "project");
		model.addAttribute("listCondition", "projectWork");
		model.addAttribute("status", status);
		HttpSession session = request.getSession();
		String memNum = ((Member)(session.getAttribute("loginUser"))).getMemberNum();
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(projectNo);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		work.setProjectNo(projectNo);
		work.setStatus(status);
		work.setMemNum(memNum);
		try {
			 List<Work> wList = service.printAllWork(work, pi);
			 model.addAttribute("projectNo", projectNo);
			 model.addAttribute("wList", wList);
			 model.addAttribute("pi", pi);
			 model.addAttribute("currentPage", currentPage);
			 return("work/workList");
		}catch(Exception e) {
			model.addAttribute("msg", "게시글 전체조회 실패");
			return("common/errorPage");
		}
	}
	
	//업무현황 상세 페이지
			@RequestMapping(value="/project/workDetail.sw", method = RequestMethod.GET)
				public ModelAndView workDetail(
						ModelAndView mv
						,@RequestParam(value = "workNo" , required = false) Integer workNo
						,@RequestParam(value = "projectNo", required=false) Integer projectNo) {
				try {
					mv.addObject("myCondition", "project");
					mv.addObject("listCondition", "projectWork");
					Work work = service.printOneByNo(workNo);
					if(workNo != null) {
						mv.addObject("work", work);
						mv.addObject("workNo", workNo);
						mv.addObject("projectNo", projectNo);
						mv.setViewName("work/workDetail");
					}else {
						mv.addObject("msg", "공지사항 상세조회 실패");
						mv.setViewName("common/errorPage");
					}
				}catch(Exception e) {
					mv.addObject("msg", e.toString());
					mv.setViewName("common/errorPage");
				}
				return mv;
			}
			
		//업무현황 등록 화면 
		@RequestMapping(value="/project/workWriteView.sw")
		public String workWriteView(Model model
				,@RequestParam(value="projectNo", required=false) Integer projectNo) {
			Date nowTime = new Date();
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		    model.addAttribute("myCondition", "project");
			model.addAttribute("listCondition", "projectWork");
		    model.addAttribute("nowTime", sf.format(nowTime));
		    model.addAttribute("projectNo", projectNo);
			return "work/workWriteForm";
		}
		
		//업무현황 등록
		@RequestMapping(value="/project/workRegister.sw", method=RequestMethod.POST)
		public ModelAndView workRegister(ModelAndView mv
				,@ModelAttribute Work work
				,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
				,@RequestParam(value="projectNo", required=false) Integer projectNo
				,HttpServletRequest request) {
			try {
					if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
						HashMap<String, String> fileMap = saveFile(uploadFile, request); // 업로드한 파일 저장하고 경로 리턴
						String filePath = fileMap.get("filePath");
						String fileReName = fileMap.get("fileName");
						if(filePath != null && !filePath.equals("")) {
							work.setFileName(uploadFile.getOriginalFilename());
							work.setFileReName(fileReName);
							work.setFilePath(filePath);
						}
					}
					work.setProjectNo(projectNo);
				int result = service.registerWork(work);
				if(result > 0) {
					mv.setViewName("redirect:/project/workList.sw?projectNo=" + work.getProjectNo());
				}else {
					mv.addObject("msg", "업무현황 등록 실패 ");
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
			String savePath = root + "\\wkuploadFiles";
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
			
		//업무현황 수정화면 
				@RequestMapping(value="/project/workModifyView.sw", method=RequestMethod.GET)
					public String workModifyView(
							Model model
							, @RequestParam(value = "workNo", required =false) Integer workNo
							, @RequestParam(value = "projectNo", required=false) Integer projectNo) {
						try {
							model.addAttribute("myCondition", "project");
							model.addAttribute("listCondition", "projectWork");
							Work work = service.printOneByNo(workNo);
							if(work != null) {
								model.addAttribute("work", work);
								model.addAttribute("projectNo", projectNo);
								return "work/workUpdateView";
							}else {
								model.addAttribute("msg", "No Data Found!!");
								return "common/errorPage";
							}
						}catch(Exception e) {
							model.addAttribute("msg", e.toString());
							return "common/errorPage";
						}
				}
				
				//업무현황 수정 
				@RequestMapping(value="/project/workUpdate.sw", method=RequestMethod.POST)
					public ModelAndView workUpdate(
							ModelAndView mv
							,@ModelAttribute Work work
				 			, @RequestParam(value="projectNo", required=false) Integer projectNo
				 			, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
							, HttpServletRequest request) {
					try {
						if(reloadFile != null && !reloadFile.isEmpty()) {
							deleteFile(work.getFilePath(), request);
							HashMap<String, String> fileMap = saveFile(reloadFile, request);
							String savePath = fileMap.get("filePath");
							String fileReName = fileMap.get("fileName");
							if(savePath != null) {
								work.setFileName(reloadFile.getOriginalFilename());
								work.setFileReName(fileReName);
								work.setFilePath(savePath); 
							}
						}
						int result = service.modifyWork(work);
						if(result > 0) {
							mv.addObject("projectNo", projectNo);
							mv.setViewName("redirect:/project/workDetail.sw?projectNo=" + projectNo + "&workNo=" + work.getWorkNo());
						}else {
							mv.addObject("msg", "업무현황 수정실패");
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
					if(deleteFile.exists()) {
						deleteFile.delete();
					}
				} 	
				
				//첨부파일 삭제 
				@RequestMapping(value="/project/workFileDelete.sw", method=RequestMethod.GET)
				public String fileDelete(ModelAndView mv
						, @RequestParam(value ="filePath", required=false) String filePath 
						, @RequestParam(value = "workNo", required =false) Integer workNo 
						, @RequestParam(value="projectNo", required=false) Integer projectNo
						, HttpServletRequest request  ){
								deleteFile(filePath, request);
						int result = service.removeFileInfo(workNo);
						return "redirect:/project/workModifyView.sw?projectNo="+ projectNo +"&workNo="+ workNo +"&projectNo=" +projectNo;
				 
			}		
				
				//업무현황 삭제 
				@RequestMapping(value="/project/workDelete.sw", method=RequestMethod.GET)
				public String workDelete(
						Model model
						, @ModelAttribute Work work
						, @RequestParam(value="workNo" , required=false) Integer workNo
						, @RequestParam(value="projectNo", required=false) Integer projectNo) {
					 try {
						 int result = service.removeWork(workNo);
						 work.setProjectNo(projectNo);
						 if(result > 0) {
							 return "redirect:/project/workList.sw?projectNo="+ projectNo;
						 }else
							 model.addAttribute("msg", "공지사항 삭제 실패");
						 	 return "common/errorPage";
					 }catch(Exception e) {
							 model.addAttribute("msg", e.toString());
							 return("common/errorPage");
						}
			}
	}

	
			
		


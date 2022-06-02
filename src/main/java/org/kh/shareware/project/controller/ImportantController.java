package org.kh.shareware.project.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.common.Pagination;
import org.kh.shareware.project.domain.Important;
import org.kh.shareware.project.service.ImportantService;
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
public class ImportantController {

	@Autowired
	private ImportantService service;
	
	//중요공지 목록
	@RequestMapping(value="/project/importantList.sw", method = RequestMethod.GET)
	public String importantListView(Model model
			,@RequestParam(value="projectNo", required=false) Integer projectNo 
			,@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(projectNo);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		try {
			 List<Important> iList = service.printAllImportant(projectNo, pi);
			 model.addAttribute("myCondition", "project");
			 model.addAttribute("listCondition", "projectImportant");
		 	 model.addAttribute("projectNo", projectNo);
			 model.addAttribute("pi", pi);
			 model.addAttribute("iList", iList);
			 model.addAttribute("currentPage", currentPage);
			return("important/importantList");
		}catch(Exception e){
			model.addAttribute("msg", "게시글 전체조회 실패");
			return("common/errorPage");
		}
	}
	//중요공지 상세 페이지 
	@RequestMapping(value="/project/importantDetail.sw", method = RequestMethod.GET )
		public ModelAndView importantDetail(
				ModelAndView mv
				,@RequestParam(value = "importantNo" , required = false) Integer importantNo
				,@RequestParam(value = "projectNo", required=false) Integer projectNo) {
		try {
			mv.addObject("myCondition", "project");
			mv.addObject("listCondition", "projectImportant");
			service.updateCount(importantNo);
			Important important = service.printOneByNo(importantNo);
			if(importantNo != null) {
				mv.addObject("important", important);
				mv.addObject("projectNo", projectNo);
				mv.setViewName("important/importantDetail");
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
	
	//중요공지 등록 화면 
	@RequestMapping(value="/project/importantWriteView.sw")
	public String importantWriteView(Model model
			,@RequestParam(value="projectNo", required=false) Integer projectNo) {
		Date nowTime = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    model.addAttribute("myCondition", "project");
		model.addAttribute("listCondition", "projectImportant");
	    model.addAttribute("nowTime", sf.format(nowTime));
	    model.addAttribute("projectNo", projectNo);
		return "important/importantWriteForm";
	}
	
	//중요공지 등록
	@RequestMapping(value="/project/importantRegister.sw", method=RequestMethod.POST)
	public ModelAndView importantRegister(ModelAndView mv
			,@ModelAttribute Important important
			,@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,@RequestParam(value="projectNo", required=false) Integer projectNo
			,HttpServletRequest request) {
		try {
				if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
					HashMap<String, String> fileMap = saveFile(uploadFile, request); // 업로드한 파일 저장하고 경로 리턴
					String filePath = fileMap.get("filePath");
					String fileReName = fileMap.get("fileName");
					if(filePath != null && !filePath.equals("")) {
						important.setFileName(uploadFile.getOriginalFilename());
						important.setFileReName(fileReName);
						important.setFilePath(filePath);
					}
				}
				important.setProjectNo(projectNo);
			int result = service.registerImportant(important);
			if(result > 0) {
				mv.setViewName("redirect:/project/importantList.sw?projectNo=" + important.getProjectNo());
			}else {
				mv.addObject("msg", "공지사항 등록 실패 ");
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
		String savePath = root + "\\iuploadFiles";
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
	
	//중요공지 수정화면 
	 @RequestMapping(value="/project/importantModifyView.sw", method=RequestMethod.GET)
		public String importantModifyView(
				  Model model
				, @RequestParam(value = "importantNo", required =false) Integer importantNo
				, @RequestParam(value = "projectNo", required=false) Integer projectNo) {
			try {
				model.addAttribute("myCondition", "project");
				model.addAttribute("listCondition", "projectImportant");
				Important important = service.printOneByNo(importantNo);
				if(important != null) {
					model.addAttribute("important", important);
					model.addAttribute("projectNo", projectNo);
					return "important/importantUpdateView";
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
	 //중요공지 수정
	 @RequestMapping(value="/project/importantUpdate.sw", method=RequestMethod.POST)
	 	public ModelAndView importantUpdate(
	 			ModelAndView mv
	 			,@ModelAttribute Important important
	 			, @RequestParam(value="projectNo", required=false) Integer projectNo
	 			, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
				, HttpServletRequest request) {
		 try {
				if(reloadFile != null && !reloadFile.isEmpty()) {
					deleteFile(important.getFilePath(), request);
					HashMap<String, String> fileMap = saveFile(reloadFile, request);
					String savePath = fileMap.get("filePath");
					String fileReName = fileMap.get("fileName");
					if(savePath != null) {
						important.setFileName(reloadFile.getOriginalFilename());
						important.setFileReName(fileReName);
						important.setFilePath(savePath); 
					}
				}
				int result = service.modifyImportant(important);
				if(result > 0) {
					mv.addObject("projectNo", projectNo);
					mv.setViewName("redirect:/project/importantDetail.sw?projectNo=" + projectNo + "&importantNo=" + important.getImportantNo());
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
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
		}
		
		//첨부파일 삭제 
		@RequestMapping(value="/project/importantFileDelete.sw", method=RequestMethod.GET)
		public String fileDelete(ModelAndView mv
				, @RequestParam(value="filePath", required=false) String filePath 
				, @RequestParam(value = "importantNo", required =false) Integer importantNo 
				, @RequestParam(value="projectNo", required=false) Integer projectNo
				, HttpServletRequest request  ){
						deleteFile(filePath, request);
				int result = service.removeFileInfo(importantNo);
				return "redirect:/project/importantModifyView.sw?projectNo="+ projectNo +"&importantNo="+ importantNo +"&projectNo=" +projectNo;
		 
	}
		//중요공지 삭제 
		 @RequestMapping(value="/project/importantDelete.sw", method=RequestMethod.GET)
		 public String importantDelete(
				 Model model
				 , @ModelAttribute Important important
				 , @RequestParam(value="importantNo" , required=false) Integer importantNo
				 , @RequestParam(value="projectNo", required=false) Integer projectNo) {
			 try {
				 int result = service.removeImportant(importantNo);
				 important.setProjectNo(projectNo);
				 if(result > 0) {
					 return "redirect:/project/importantList.sw?projectNo="+ projectNo;
				 }else
					 model.addAttribute("msg", "공지사항 삭제 실패");
				 	 return "common/errorPage";
			 }catch(Exception e) {
					 model.addAttribute("msg", e.toString());
					 return("common/errorPage");
				}
	}
	 			
}

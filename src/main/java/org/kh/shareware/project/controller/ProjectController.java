package org.kh.shareware.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.service.ProjectService;
import org.kh.shareware.report.domain.Week;
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
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	//프로젝트 생성 등록 화면 
	@RequestMapping(value="/project/newProjectView.sw")
	public String registerProject(Model model) {
//		model.addAttribute("listCondition", "dailyWrite");
		return "project/newProject";
	}
	
	//프로젝트 생성 등록
	@RequestMapping(value="/project/projectRegister.sw", method=RequestMethod.POST)
	public ModelAndView projectRegister(ModelAndView mv
			,@ModelAttribute Project project
			,HttpServletRequest request){
		int result = service.registerProject(project);
		if(result > 0) {
			mv.setViewName("redirect:/project/projectList.sw");
		}else {
			mv.addObject("msg", "프로젝트 생성 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
}

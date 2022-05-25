package org.kh.shareware.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.kh.shareware.project.common.PageInfo;
import org.kh.shareware.project.common.Pagination;
import org.kh.shareware.project.domain.Important;
import org.kh.shareware.project.domain.Participant;
import org.kh.shareware.project.domain.Project;
import org.kh.shareware.project.domain.Work;
import org.kh.shareware.project.domain.WorkChart;
import org.kh.shareware.project.service.ImportantService;
import org.kh.shareware.project.service.ProjectService;
import org.kh.shareware.project.service.WorkService;
import org.kh.shareware.report.domain.Daily;
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
	
	@Autowired
	private WorkService wService;
	
	@Autowired
	private ImportantService iService;
	
	
	//프로젝트 목록
	@RequestMapping(value="/project/projectList.sw" , method = RequestMethod.GET)
	public ModelAndView projectListView(Model model, ModelAndView mv
			,HttpServletRequest request
			,@RequestParam(value="pStatus", required=false) String pStatus
			,@RequestParam(value="page", required=false) Integer page
			,@ModelAttribute Project project) {
		model.addAttribute("myCondition", "project");
		HttpSession session = request.getSession();
		String memberNum = ((Member)session.getAttribute("loginUser")).getMemberNum();
		int currentPage = (page != null) ? page : 1;
		try {
			project.setProjectMade(memberNum);
			if(pStatus == null) { // 전체보기
				pStatus = "A";
			}
			project.setpStatus(pStatus);
			int totalCount = service.getListCount(project);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
			List<Project> pList = service.printAllProject(project, pi);
			mv.addObject("currentPage", currentPage);
			mv.addObject("pi", pi);
			mv.addObject("pList", pList);
			mv.addObject("pStatus", pStatus);
			mv.setViewName("project/projectList");
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
		
	}
	
	//프로젝트 검색 (제목만)
	@RequestMapping(value="/project/projectSearch.sw")
	public ModelAndView searchList(Model model, ModelAndView mv
			, @ModelAttribute Search search
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			, @RequestParam(value="pStatus", required=false) String pStatus) {
				model.addAttribute("myCondition", "project");
			try {
				HttpSession session = request.getSession();
				search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum()); //
				if(pStatus == null) { // 전체보기
					pStatus = "A";
				}
				search.setType(pStatus);
				int currentPage = (page != null) ? page : 1;
				int totalCount = service.getSearchCount(search);
				PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
				List<Project> pList = service.printSearch(search, pi);
				mv.addObject("currentPage", currentPage);
				mv.addObject("pi", pi);
				mv.addObject("pList", pList);
				mv.addObject("pStatus", pStatus);
				mv.setViewName("project/projectList");
			}catch(Exception e) {
				mv.addObject("msg", e.toString());
				mv.setViewName("common/errorPage");
			}

		
		return mv;
		
	}
	//프로젝트 정보(상세)
		@RequestMapping(value="/project/detail.sw", method=RequestMethod.GET)
		public ModelAndView projectDetailVeiw(Model model,
					ModelAndView mv
					,@RequestParam(value= "projectNo") int projectNo
					,@ModelAttribute Participant participant
					,@ModelAttribute Member member) {
				model.addAttribute("myCondition", "project");
				model.addAttribute("listCondition", "projectDetail");
			try {
				Project project = service.printOneProjectDetail(projectNo);
				List<Member> pList = service.printAllParticipant(projectNo);
				if(project != null) {
					mv.addObject("pList", pList);
					mv.addObject("project",project );
					mv.addObject("projectNo",projectNo );
					mv.setViewName("project/projectDetail");
				}else {
					mv.addObject("msg", "프로젝트 조회 실패");
					mv.setViewName("common/errorPage");
				}
			}catch(Exception e){
				mv.addObject("msg", e.toString());
				mv.setViewName("common/errorPage");
			}
			return mv;
		}
		
	//프로젝트 정보 수정화면
		 @RequestMapping(value="/project/projectModifyView.sw", method=RequestMethod.GET)
			public String dailyModifyView(
					  Model model
					, @RequestParam("projectNo") int projectNo
					,@ModelAttribute Participant participant
					,@ModelAttribute Member member) {
			 try {
					// 수정화면에 필요한 데이터 DB 가져오기
					Project project = service.printOneProject(projectNo);
					List<Member> pList = service.printAllParticipant(projectNo);
					model.addAttribute("myCondition", "project");
					model.addAttribute("listCondition", "projectDetail");
					if(project != null) {
						model.addAttribute("project", project);
						model.addAttribute("projectNo", projectNo);
						model.addAttribute("pList", pList);
						return "project/projectUpdateView";
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
	//프로젝트 정보 수정
		 @RequestMapping(value="/project/projectUpdate.sw", method=RequestMethod.POST)
			public ModelAndView projectUpdate(
					ModelAndView mv
					, @ModelAttribute Project project
					, HttpServletRequest request
					, @ModelAttribute Participant participant
					, @RequestParam(value="memNum") String memNum
					, @RequestParam(value= "projectNo", required=false) Integer projectNo) {
				try {
					int result = service.modifyProject(project);
					int pResult= 0;
					if(!memNum.equals("")) {
						int delResult = service.removeParticipant(participant);
						String[] parArr = memNum.split(","); // [0]정은진 / [1]권지혜 / [2]김아름
						for(int i = 0; i < parArr.length; i++) {
							participant.setMemberNum(parArr[i]); // 사원번호
							pResult = service.registerParticipant(participant);
						}
					}
					if(result > 0) {
						mv.addObject("projectNo", projectNo);
						mv.setViewName("redirect:/project/detail.sw?projectNo=" + project.getProjectNo());
					}else {
						mv.addObject("msg", "프로젝트 수정실패");
						mv.setViewName("common/errorPage");
					}
				} catch(Exception e) {
					mv.addObject("msg", e.toString());
					mv.setViewName("common/errorPage");
				}
				return mv;
			}
		 
		//프로젝트 삭제 
		 @RequestMapping(value="/project/projectDelete.sw", method=RequestMethod.GET)
		 public String projectDelete(
				 Model model
				 , @RequestParam(value= "projectNo", required=false) Integer projectNo) {
			 try {
				 int result = service.removeProject(projectNo);
				 if(result > 0) {
					 model.addAttribute("projectNo", projectNo);
					 return "redirect:/project/projectList.sw";
				 }else
					 model.addAttribute("msg", "프로젝트 삭제 실패");
				 	 return "common/errorPage";
			 }catch(Exception e) {
					 model.addAttribute("msg", e.toString());
					 return("common/errorPage");
				}
	} 
	//프로젝트 메인페이지
	@RequestMapping(value="/project/main.sw", method=RequestMethod.GET)
	public ModelAndView projectMainView(Model model,
				ModelAndView mv
				,@RequestParam("projectNo") int projectNo) {
			model.addAttribute("myCondition", "project");
			model.addAttribute("listCondition", "projectMain");
		try {
			Project project = service.printOneProject(projectNo);
			List<Work> wList = wService.printAllWork(projectNo);
			List<Important> iList = iService.printAllImportant(projectNo);
			List<WorkChart> cList = service.printAllChart(projectNo);
			List<Member> pList = service.printAllParticipant(projectNo);
			if(project != null) {
				mv.addObject("project", project);
				mv.addObject("projectNo", projectNo);
				mv.addObject("wList", wList);
				mv.addObject("iList", iList);
				mv.addObject("cList", cList);
				mv.addObject("pList", pList);
				mv.setViewName("project/projectMain");
			}else {
				mv.addObject("msg", "프로젝트 조회 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e){
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	
	//프로젝트 생성 화면 
	@RequestMapping(value="/project/newProjectView.sw")
	public String registerProject(Model model) {
//		model.addAttribute("listCondition", "dailyWrite");
		return "project/newProject";
	}
	
	//프로젝트 등록
	@RequestMapping(value="/project/projectRegister.sw", method=RequestMethod.POST)
	public ModelAndView projectRegister(ModelAndView mv
			,@ModelAttribute Project project
			,HttpServletRequest request
			,@ModelAttribute Participant participant
			,@RequestParam(value="memNum") String memNum
			){ // 정은진,권지혜,김아름
		project.setProjectNo(0);
		int result = service.registerProject(project);
		// 참여자 등록
		int pResult = 0;
		String[] parArr = memNum.split(","); // [0]정은진 / [1]권지혜 / [2]김아름
		for(int i = 0; i < parArr.length; i++) {
			participant.setMemberNum(parArr[i]); // 사원번호
			pResult = service.registerParticipant(participant);
		}
		if(result < 1) {
			mv.addObject("msg", "프로젝트 생성 실패");
			mv.addObject("msg", "프로젝트 생성 실패");
			mv.setViewName("common/errorPage");
		}else if(pResult < 1){
			mv.addObject("msg", "참여자 등록 실패");
		}else {
			mv.setViewName("common/errorPage");
			mv.setViewName("redirect:/project/projectList.sw");
		}
		return mv;
	}
	//업무진행률 등록 
	@RequestMapping(value="/project/workChart.sw")
	public ModelAndView chartRegister(ModelAndView mv
			, @ModelAttribute WorkChart workChart 
			, @RequestParam(value= "projectNo", required=false) Integer projectNo) {
		 try {
			 int chart = service.printChart(workChart);
			 int result = 0;
			 if(chart > 0) {
				 result = service.modifyChart(workChart);
			 }else {
				 result = service.registerChart(workChart);
			 }
	         if(result > 0) {
	        	 mv.addObject("msg", "업무 진행률 등록 성공");
	        	 mv.addObject("loc", "/project/main.sw?projectNo=" + projectNo);
	        	 mv.setViewName("common/msg");
	         }else {
	        	 mv.addObject("msg", "업무 진행률 등록 실패!");
	        	 mv.addObject("loc", "/project/main.sw?projectNo=" + projectNo);
	        	 mv.setViewName("common/msg");
	         }
	      }catch(Exception e) {
	    	  mv.addObject("msg", e.toString());
	    	  mv.setViewName("common/errorPage");
	      }
		 return mv;
		}
}

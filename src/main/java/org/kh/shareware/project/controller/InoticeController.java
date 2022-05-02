//package org.kh.shareware.project.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.kh.shareware.member.domain.Member;
//import org.kh.shareware.project.domain.Inotice;
//import org.kh.shareware.project.domain.Participant;
//import org.kh.shareware.project.domain.Project;
//import org.kh.shareware.project.service.InoticeService;
//import org.kh.shareware.report.domain.Daily;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class InoticeController {
//	
//	@Autowired 
//	private InoticeService service;
//	
//	//중요공지 목록
//		@RequestMapping(value="/project/inoticeList.sw" , method = RequestMethod.GET)
//		public ModelAndView projectListView(ModelAndView mv
//				,@RequestParam(value= "projectNo", required=false) Integer projectNo) {
//			try {
//				List<Inotice> iList = service.printAllInotice(projectNo);
//					mv.addObject("iList", iList);
//					mv.setViewName("inotice/inoticeList");
//			}catch(Exception e) {
//				mv.addObject("msg", e.toString());
//				mv.setViewName("common/errorPage");
//			}
//			return mv;
//		}
//		
//		
//	//중요공지 등록 화면 
//		@RequestMapping(value="/project/inoticeWriteView.sw")
//		public String iNoticeWriteView(Model model) {
//			Date nowTime = new Date();
//		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		    model.addAttribute("nowTime", sf.format(nowTime));
//			return "inotice/inoticeWriteForm";
//		}
//		
//	//중요공지 등록
//		@RequestMapping(value="/project/inoticeRegister.sw", method=RequestMethod.POST)
//		public ModelAndView projectRegister(ModelAndView mv
////				,@RequestParam(value= "inoitceTitle") String inoitceTitle
////				,@RequestParam(value= "inoticeContent") String inoticeContent
////				,@RequestParam(value= "inoticeDate") String inoticeDate
//				,@ModelAttribute Inotice inotice
//				,@ModelAttribute Project project){
////			Inotice inotice = new Inotice();
////			inotice.set
////			inotice.setInoitceTitle(inoitceTitle);
////			inotice.setInoticeContent(inoticeContent);
////			inotice.setInoticeDate(inoticeDate);
//			int result = service.registerInotice(inotice);
//			if(result < 1) {
//				mv.addObject("msg", "공지사항 등록 실패");
//				mv.setViewName("common/errorPage");
//			}else {
//				mv.setViewName("common/errorPage");
//				mv.setViewName("redirect:/project/inoticeList.sw?projectNo=" +  project.getProjectNo());
//			}
//			return mv;
//		}
//}

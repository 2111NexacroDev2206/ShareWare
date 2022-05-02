package org.kh.shareware.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.kh.shareware.project.domain.Important;
import org.kh.shareware.project.service.ImportantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImportantController {

	@Autowired
	private ImportantService service;
	
	//중요공지 목록
	@RequestMapping(value="/project/importantList.sw", method = RequestMethod.GET)
	public ModelAndView importantListView(ModelAndView mv
			,@RequestParam(value="projectNo", required=false) Integer projectNo ) {
		try {
			 List<Important> iList = service.printAllImportant(projectNo);
				mv.addObject("iList", iList);
				mv.setViewName("important/importantList");
		}catch(Exception e){
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//중요공지 등록 화면 
	@RequestMapping(value="/project/importantWriteView.sw")
	public String importantWriteView(Model model) {
		Date nowTime = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    model.addAttribute("nowTime", sf.format(nowTime));
		return "important/importantWriteForm";
	}
}

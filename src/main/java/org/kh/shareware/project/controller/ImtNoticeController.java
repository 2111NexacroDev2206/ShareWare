package org.kh.shareware.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.report.domain.Daily;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImtNoticeController {
	
	//중요공지 등록 화면 
		@RequestMapping(value="/inotice/inoticeWriteView.sw")
		public String iNoticeWriteView(Model model) {
			Date nowTime = new Date();
		    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		    model.addAttribute("nowTime", sf.format(nowTime));
			return "inotice/inoticeWriteForm";
		}
		
}

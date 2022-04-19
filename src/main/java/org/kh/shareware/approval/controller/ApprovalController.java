package org.kh.shareware.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApprovalController {

	@RequestMapping(value = "/approval/draftDocWriteView.sw")
	public String draftDocWriteView(Model model) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", "draft");
		return "approval/draftDocWrite";
	}
	
}

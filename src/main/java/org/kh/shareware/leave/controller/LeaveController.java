package org.kh.shareware.leave.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LeaveController {

	@RequestMapping(value="/leave/leaveListViewEmp.sw",method=RequestMethod.GET)
	public String leaveListViewEmp(Model model) {
		
		
		return null;
}
}
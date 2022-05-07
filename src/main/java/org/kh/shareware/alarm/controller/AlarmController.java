package org.kh.shareware.alarm.controller;

import java.util.List;

import org.kh.shareware.alarm.domain.Alarm;
import org.kh.shareware.alarm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class AlarmController{
	
	@Autowired
	private AlarmService alService;
	
	@ResponseBody
	@RequestMapping(value = "/alarm/listView.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String alarmListView(@RequestParam(value="memNum") String memNum) {
		List<Alarm> aList = alService.printAllAlarm(memNum);
		if(!aList.isEmpty()) {
			return new Gson().toJson(aList);
		}
		return null;
	}
}

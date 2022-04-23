package org.kh.shareware.mail.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
	
	@Autowired
	MailService mService;
	
	//메일쓰기 작성 화면
	@RequestMapping(value="/mail/WriteView.sw")
	public String mailWriteView() {
		return "mail/mailWriteForm";
	
	} 
	//내게쓰기 작성 화면
	@RequestMapping(value="/mail/WriteMyView.sw")
	public String maiMyWriteView() {
		return "mail/mailMyWriteForm";
	
	} 
	//메일 발송
	@RequestMapping(value="mail/mailRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailRegister(ModelAndView mv, 
			@ModelAttribute Mail mail
			,@ModelAttribute MailRec mailRec
			,@ModelAttribute MailRef mailRef
			,@ModelAttribute MailFile mailFile
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,HttpServletRequest request) {
		
		try {
		
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				HashMap <String, String>  fileMap = saveFile(uploadFile, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
			
				if(filePath !=null && !filePath.equals("")) {
					mailFile.setMailFileName(uploadFile.getOriginalFilename());
					mailFile.setMailFileRename(fileRename);
					mailFile.setMailFilePath(filePath);
				}
			
			}
			int mResult = mService.registerMail(mail);
			int recResult = mService.registerMailRec(mailRec);
			int refResult = mService.registerMailRef(mailRef);
			int fResult;
			if(uploadFile != null) {
				 fResult = mService.registerMailFile(mailFile);
			}
			if(mResult > 0 && recResult>0 && refResult>0) {
				mv.addObject("msg", "등록 성공");
//				mv.setViewName("redirect:/mail/mailToList");
			} else {
				mv.addObject("msg", "메일 발신 실패");
				mv.setViewName("common/errorPage");
		} 
			
		}catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		
			
		return mv;
	}


	public HashMap<String, String> saveFile(MultipartFile file, HttpServletRequest request) {
		String filePath ="";
		HashMap<String, String> fileMap = new HashMap<String, String>();
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String savePath = root + "\\mUploadFiles";
		File folder = new File(savePath);
		if(!folder.exists()) folder.mkdir();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		String renameFileName = sdf.format(new Date(System.currentTimeMillis()))+"." + extensionName;
		filePath = folder + "\\" + file.getOriginalFilename();
		fileMap.put("filePath", filePath);
		fileMap.put("fileName", renameFileName);
		
		try {
			file.transferTo(new File(filePath));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileMap;
	}
	
	@RequestMapping(value="mail/mailTemRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailTemporaryRegister (ModelAndView mv, 
		@ModelAttribute Mail mail
		,@ModelAttribute MailRec mailRec
		,@ModelAttribute MailRef mailRef
		,@ModelAttribute MailFile mailFile
		, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
		,HttpServletRequest request) {
	
	try {
	
		if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
			HashMap <String, String>  fileMap = saveFile(uploadFile, request);
			String filePath = fileMap.get("filePath");
			String fileRename = fileMap.get("fileName");
		
			if(filePath !=null && !filePath.equals("")) {
				mailFile.setMailFileName(uploadFile.getOriginalFilename());
				mailFile.setMailFileRename(fileRename);
				mailFile.setMailFilePath(filePath);
			}
		
		}
		int mResult = mService.registerTemMail(mail);
		int recResult = mService.registerTemMailRec(mailRec);
		int refResult = mService.registerTemMailRef(mailRef);
		int fResult;
		if(uploadFile != null) {
			 fResult = mService.registerTemMailMyFile(mailFile);
		} else {
			fResult =0;
		}
		if(mResult > 0 && recResult>0 && refResult>0) {
			mail.setMailType("T");
			mv.addObject("msg", "등록 성공");
	//		mv.setViewName("redirect:/mail/mailToList");
		} else {
			mv.addObject("msg", "메일 발신 실패");
			mv.setViewName("common/errorPage");
	} 
		
	}catch (Exception e) {
		mv.addObject("msg", e.toString());
		mv.setViewName("common/errorPage");
	}
	
	
		
	return mv;
	}
		
	
	}
	
	
	

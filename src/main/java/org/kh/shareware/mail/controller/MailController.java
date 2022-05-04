package org.kh.shareware.mail.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.service.MailService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//메일 발송 등록
	@RequestMapping(value="/mail/mailRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailRegister(ModelAndView mv, 
			@ModelAttribute Mail mail
			,@ModelAttribute MailRec mailRec
			,@ModelAttribute MailRef mailRef
			,@ModelAttribute MailFile mailFile
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			,HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				HashMap <String, String>  fileMap = saveFile(uploadFile, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
				 
				
				if(filePath != null && !filePath.equals("")) {
					mailFile.setMailFileName(uploadFile.getOriginalFilename());
					mailFile.setMailFileRename(fileRename);
					mailFile.setMailFilePath(filePath);
					mail.setfStatus("1");
				}
			
			}
			int mResult = mService.registerMail(mail);
			int recResult = mService.registerMailRec(mailRec);
			int refResult = mService.registerMailRef(mailRef);
			int fResult = mService.registerMailFile(mailFile);
			
			if(mResult > 0 && recResult>0 && refResult>0 ) {
				mv.addObject("msg", "등록 성공");
				mv.setViewName("/mail/mailDetail");
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
	//내게쓰기 작성 화면
		@RequestMapping(value="/mail/WriteMyView.sw")
		public String maiMyWriteView() {
			return "mail/mailMyWriteForm";
		
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
	//임시 저장 등록
	@RequestMapping(value="/mail/mailTemRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailTemporaryRegister (ModelAndView mv, 
		@ModelAttribute Mail mail
		,@ModelAttribute MailRec mailRec
		,@ModelAttribute MailRef mailRef
		,@ModelAttribute MailFile mailFile
		, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
		,HttpServletRequest request) {
	
	try {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		mail.setMemNum(member.getMemberNum());
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
		int fResult = mService.registerTemMailMyFile(mailFile);
	
		if(mResult > 0 && recResult>0 && refResult>0 && fResult > 0) {
			mail.setMailType("T");
			mv.addObject("msg", "등록 성공");
			mv.setViewName("redirect:/mail/mailTemListView.sw");
	
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
	// 메일 리스트 조회
	@RequestMapping( value="/mail/{param}mailListView.sw", method= RequestMethod.GET )
	public ModelAndView mailListView(ModelAndView mv
		, @PathVariable("param") String mailCategory
		, HttpServletRequest request
		, @RequestParam(value="page", required = false) Integer page
		,@ModelAttribute Mail mail
		) {
		
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalmCount = mService.getMailCount(mail);
			int totalmRecCount = mService.getMailRecCount(mail);
			int totalmMyCount = mService.getMailMyCount(mail);
			int totalmFileCount = mService.getMailFileCount(mail);
			PageInfo pi = null;
			
			 
			List<Mail> mList = null;
			List<Mail> mRecList = null;
			List<Mail> mMyList = null;
			List<Mail> mFileList = null;
			String viewName = "mail/mailList";
			
			
			// 보낸 편지함일 때
			if(mailCategory.equals("R")) {
				pi = Pagination.getPageInfo(currentPage, totalmCount);
				mList = mService.printMail(mail, pi);
				mv.addObject("mList", mList);
			//받은 편지함일 때
			}else if(mailCategory.equals("S")) {
				 pi = Pagination.getPageInfo(currentPage, totalmRecCount);
				mRecList = mService.printMailRec(mail, pi);
				mv.addObject("mList", mRecList);
			//내게 쓴 편지함 일 때
			}else if(mailCategory.equals("M")){
				pi = Pagination.getPageInfo(currentPage, totalmMyCount);
				mMyList = mService.printMailMy(mail, pi);
				mv.addObject("mList", mMyList);
			//파일 편지함일 때
			} else if (mailCategory.equals("F")){
				pi = Pagination.getPageInfo(currentPage, totalmFileCount);
				mFileList = mService.printMailFile(mail, pi);
				mv.addObject("mList", mFileList);
			}
			mv.addObject("pi", pi);
			mv.addObject("mailCategory", mailCategory);
			mv.setViewName(viewName);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		
		return mv;
	}
	
	//임시저장 목록 조회
	@RequestMapping( value="/mail/mailTemListView.sw", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView mailTemListView(ModelAndView mv
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			,@ModelAttribute Mail mail) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalCount = mService.getTemMailCount(mail);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
			List<Mail> tList = mService.printTemMail(mail, pi);
			mv.addObject("pi", pi);
			if(!tList.isEmpty()) {
				mv.addObject("tList", tList);
				mv.setViewName("mail/mailTemList");
				
			} else {
				mv.addObject("msg", "임시 저장 조회 실패");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
		
	}
	//검색 목록 조회
	@RequestMapping( value="/mail/{param}mailSearch.sw", method = RequestMethod.GET)
	public ModelAndView mailSearchList(
			ModelAndView mv
			,@ModelAttribute Search search
			,@PathVariable("param") String mailCategory
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			, @ModelAttribute Mail mail) {
		
		try {
			List<Mail> searchList= null;
			List<Mail> searchRecList = null;
			List<Mail> searchMyList = null;
			List<Mail> searchFileList = null;
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기 // 세션 값에서 사원번호 가져오기
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalmCount = mService.getSearchMailCount(search);
			int totalmRecCount = mService.getSearchMailRecCount(search);
			int totalMyCount = mService.getSearchMailMyCount(search);
			int totalmFileCount = mService.getSearchMailFileCount(search);
			PageInfo pi = null;
			if(mailCategory.equals("R")) {
				pi = Pagination.getPageInfo(currentPage, totalmCount);
				mv.addObject("search", search);
				searchList = mService.printSearchMail(search,pi);
				mv.addObject("mList", searchList);
			} else if(mailCategory.equals("S")) {               
				pi = Pagination.getPageInfo(currentPage, totalmRecCount);
				mv.addObject("search", search);
				searchRecList = mService.printSearchMailRec(search,pi);
				mv.addObject("mList", searchRecList);
			} else if(mailCategory.equals("M")) {
				pi = Pagination.getPageInfo(currentPage, totalMyCount);
				mv.addObject("search", search);
				searchMyList = mService.printSearchMailMy(search,pi);
				mv.addObject("mList", searchMyList);
			} else if(mailCategory.equals("F")) {
				pi = Pagination.getPageInfo(currentPage, totalmFileCount);
				mv.addObject("search", search);
				searchFileList = mService.printSearchMailFile(search,pi);
				mv.addObject("mList", searchFileList);
			} else {
				mv.addObject("msg", "검색 실패");
//				mv.addObject("loc", "/approval/draftListView.sw");
				mv.setViewName("common/msg");
			}
				mv.addObject("pi", pi);
				mv.addObject("mailCategory", mailCategory);
				mv.setViewName( "mail/mailList");
			
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
		
	}
	
	
	//메일 상세 조회
		@RequestMapping(value="/mail/mailDetailView.sw", method = RequestMethod.GET)
		public ModelAndView mailDetailView( 
			ModelAndView mv
			, @RequestParam("mailNo") int mailNo ) {
			try {
				Mail mail = mService.printOneMail(mailNo);
				MailRec mailRec = mService.printOneTemMailRec(mailNo);
				MailRef mailRef = mService.printOneTemMailRef(mailNo);
				MailFile mailFile = mService.printOneTemMailFile(mailNo);
				if(mail != null) {
					mv.addObject("mail", mail);
					mv.addObject("mailRec", mailRec);
					mv.addObject("mailRef", mailRef);
					mv.addObject("mailFile", mailFile);
					mv.setViewName("mail/mailDetail");
				
				} else {
					mv.addObject("msg", "메일 상세 조회 실패");
					mv.setViewName("common/errorPage");
				}
			} catch (Exception e) {
				mv.addObject("msg", e.toString());
				mv.setViewName("common/errorPage");
			}
		
				return mv;
				
			}
		
				//임시저장 상세 조회
				@RequestMapping(value="/mail/mailTemDetailView.sw", method = {RequestMethod.GET, RequestMethod.POST})
				public ModelAndView mailTemDetailView( 
					ModelAndView mv
					, @RequestParam("mailNo") int mailNo ) {
					try {
						Mail mail = mService.printOneTemMail(mailNo);
						MailRec mailRec = mService.printOneTemMailRec(mailNo);
						MailRef mailRef = mService.printOneTemMailRef(mailNo);
						MailFile mailFile = mService.printOneTemMailFile(mailNo);
						if(mail != null && mailRec != null && mailRef!=null && mailFile != null) {
							mv.addObject("mail", mail);
							mv.addObject("mailRec", mailRec);
							mv.addObject("mailRef", mailRef);
							mv.addObject("mailFile", mailFile);
							mv.setViewName("mail/mailTemDetail");
						} else {
							mv.addObject("msg", "메일 상세 조회 실패");
							mv.setViewName("common/errorPage");
						}
					} catch (Exception e) {
						mv.addObject("msg", e.toString());
						mv.setViewName("common/errorPage");
					}
				
						return mv;
						
					}
				
				//임시 저장 수정페이지
				@RequestMapping(value="/mail/temModifyView.sw", method = RequestMethod.GET)
				public String mailTemModifyView(
						Model model
						, @RequestParam("mailNo") int mailNo) {
					try {
						Mail mail = mService.printOneTemMail(mailNo);
						MailRec mailRec = mService.printOneTemMailRec(mailNo);
						MailRef mailRef = mService.printOneTemMailRef(mailNo);
						MailFile mailFile = mService.printOneTemMailFile(mailNo);
						if(mail != null && mailRec != null && mailRef!=null && mailFile != null) {
							model.addAttribute("mail", mail);
							model.addAttribute("mailRec", mailRec);
							model.addAttribute("mailRef", mailRef);
							model.addAttribute("mailFile", mailFile);
							return "mail/modifyTemView";
						} else {
							model.addAttribute("msg", "수정 실패");
							return "common/errorPage";
						}
					} catch (Exception e) {
						model.addAttribute("msg", e.toString());
						return "common/errorPage";
					}
					
					
				}
				//임시저장 수정
				@RequestMapping(value ="/mail/updateTemMail.sw", method = RequestMethod.POST)
				public ModelAndView mailTemUpdate(
						ModelAndView mv
						, @ModelAttribute Mail mail
						, @ModelAttribute MailRec mailRec
						, @ModelAttribute MailRef mailRef
						, @ModelAttribute MailFile mailFile
						, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
						, HttpServletRequest request) {
					
					try {
						if(reloadFile != null && !reloadFile.isEmpty()) {
							
							deleteFile(mailFile.getMailFilePath(), request);
								
							HashMap<String, String> fileMap = saveFile(reloadFile, request);
							String savePath = fileMap.get("filePath");
							String fileRename = fileMap.get("fileName");
							if(savePath != null) {
								mailFile.setMailFileName(reloadFile.getOriginalFilename());
								mailFile.setMailFileRename(fileRename);
								
							}
							int mResult = mService.modifyTemMail(mail);
							int mRecResult = mService.modifyTemMailRec(mailRec);
							int mRefResult = mService.modifyTemMailRef(mailRef);
							int mFileResult = mService.modifyTemMailFile(mailFile);
							
							if(mResult>0 && mRecResult>0 && mRefResult>0 && mFileResult>0) {
								mv.addObject("mail", mail);
								mv.addObject("mailRec", mailRec);
								mv.addObject("mailRef", mailRef);
								mv.addObject("mailFile", mailFile);
								mv.setViewName("mail/mailTemList");
							}else {
								mv.addObject("msg", "임시저장 수정 실패");
								mv.setViewName("common/errorPage");
							}
					}
					}catch (Exception e) {
						mv.addObject("msg", e.toString());
						mv.setViewName("common/errorPage");
					}
					
							return mv;
					
				}
				
				//메일 수정시 파일 삭제
		public void deleteFile(String mailFilePath, HttpServletRequest request) {
					File deleteFile = new File(mailFilePath);
					if(deleteFile.exists()) {
						deleteFile.delete();
					}
						
					}

		//체크한 목록 삭제
		@RequestMapping(value="/mail/chkMailDelete.sw", method= {RequestMethod.GET, RequestMethod.POST} )
		public String chkMailDelete(
				Model model
				, HttpServletRequest request
				) {
			
			String[] values = request.getParameterValues("valueArr");
			try {
				
				int mResult = 0;
				int mRecResult = 0;
				int mRefResult = 0;
				int mFileResult = 0;
				for(int i = 0; i<values.length; i++) {
					
					  mResult = mService.removeChkMail(Integer.parseInt(values[i]));
					  mRecResult = mService.removeChkMailRec(Integer.parseInt(values[i]));
					  mRefResult = mService.removeChkMailRef(Integer.parseInt(values[i]));
					  mFileResult = mService.removeChkMailFile(Integer.parseInt(values[i]));
				}
				 if(mResult > 0 && mRecResult >0 && mRefResult >0 && mFileResult>0) {
					 return "redirect:/mail/mailListView.sw";
					} 
				 
			else {
				model.addAttribute("msg", "공지사항 삭제 실패");
				return "common/errorPage";
			}
			  
				
			} catch (Exception e) {
				model.addAttribute("msg", e.toString());
				return "common/errorPage";
			}
			//return null;
		
					//return null;
			
		}
		//메일삭제
		@RequestMapping(value="/mail/mailDelete.sw", method = RequestMethod.GET)
		public String mailDelete(
				Model model
				, @RequestParam("mailNo") int mailNo
				 ) {
			
			try {
				
				int mResult = mService.removeMail(mailNo);
				int mRecResult = mService.removeMailRec(mailNo);
				int mRefResult = mService.removeMailRef(mailNo);
				int mFileResult = mService.removeMailFile(mailNo);
				if(mResult > 0 && mRecResult>0 && mRefResult>0 && mFileResult>0) {
					return "mail/RmailList";
				} else {
					model.addAttribute("msg", "메일 삭제 실패");
					return "common/errorPage";
				}
			} catch (Exception e) {
				model.addAttribute("msg", e.toString());
				return "common/errorPage";
			}
			
			
			
		}

}

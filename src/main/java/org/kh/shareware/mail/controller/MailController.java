package org.kh.shareware.mail.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.domain.MailSearch;
import org.kh.shareware.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

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
				mv.setViewName("redirect:/mail/RmailListView.sw");
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
		, @PathVariable("param") String mailCategory) {
		
		try {
			List<Mail> mList = null;
			List<MailRec> mRecList = null;
			List<Mail> mMyList = null;
			List<MailFile> mFileList = null;
			String viewName = "mail/mailList";
			// 보낸 편지함일 때
			if(mailCategory.equals("R")) {
				mList = mService.printMail();
				mv.addObject("mList", mList);
			//받은 편지함일 때
			}else if(mailCategory.equals("S")) {
				mRecList = mService.printMailRec();
				mv.addObject("mList", mRecList);
			//내게 쓴 편지함 일 때
			}else if(mailCategory.equals("M")){
				mMyList = mService.printMailMy();
				mv.addObject("mList", mMyList);
			// 파일 편지함일 때
			} else if (mailCategory.equals("F")){
				mFileList = mService.printMailFile();
				mv.addObject("mList", mFileList);
			}else {
				mv.addObject("msg", "받은 메일 조회 실패");
				viewName = "common/errorPage";
			}
			mv.setViewName(viewName);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		
		return mv;
	}
	
	//임시저장 목록 조회
	@RequestMapping( value="/mail/mailTemListView.sw", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView mailTemListView(ModelAndView mv) {
		try {
			List<Mail> tList = mService.printTemMail();
			
			if(!tList.isEmpty()) {
				mv.addObject("tList", tList);
				mv.setViewName("mail/mailTemList");
				
			} else {
				mv.addObject("msg", "받은 메일 조회 실패");
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
			,@ModelAttribute MailSearch mailSearch
			,@PathVariable("param") String mailCategory) {
		
		try {
			List<Mail> searchList= null;
			List<MailRec> searchRecList = null;
			List<Mail> searchMyList = null;
			List<MailFile> searchFileList = null;
			String viewName = "mail/mailList";
			if(mailCategory.equals("R")) {
				searchList = mService.printSearchMail(mailSearch);
				mv.addObject("mList", searchList);
			} else if(mailCategory.equals("S")) {
				searchRecList = mService.printSearchMailRec(mailSearch);
				mv.addObject("mList", searchRecList);
			} else if(mailCategory.equals("M")) {
				searchMyList = mService.printSearchMailMy(mailSearch);
				mv.addObject("mList", searchMyList);
			} else if(mailCategory.equals("F")) {
				searchFileList = mService.printSearchMailFile(mailSearch);
				mv.addObject("mList", searchFileList);
			} else {
				mv.addObject("msg", "받은 메일 조회 실패");
				viewName = "common/errorPage";
			}
				mv.setViewName(viewName);
			
		} catch (Exception e) {
			mv.addObject("mList", e.toString());
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
				int mRecResult =0;
				int mRefResult =0;
				int mFileResult =0;
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
					
					return "redirect:/mail/mailRListView.sw";
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

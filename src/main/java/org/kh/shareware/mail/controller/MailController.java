package org.kh.shareware.mail.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.common.Search;
import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailBmk;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;
import org.kh.shareware.mail.service.MailService;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;


@Controller
public class MailController {
	
	@Autowired
	MailService mService;
	
	//메일쓰기 작성 화면
	@RequestMapping(value="/mail/WriteView.sw")
	public ModelAndView mailWriteView(
			ModelAndView mv
			, HttpServletRequest request
			,@ModelAttribute Mail mail
			, @ModelAttribute MailBmk mailBmk) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		mail.setMemNum(member.getMemberNum());
		mail.setMailReceiver(member.getMail());
		mail.setMailSender(member.getMail());
		mailBmk.setMemNum(member.getMemberNum());
		int totalICount = mService.getIMailCount(mail);
		int totalmCount = mService.getMailCount(mail);
		int totalmRecCount = mService.getMailRecCount(mail);
		int totalmMyCount = mService.getMailMyCount(mail);
		int totalmFileCount = mService.getMailFileCount(mail);
		int readTypeNCount = mService.getMailReadCount(mail);
		int totalAppCount = mService.getAppMailCount(mail);
		int totalTemCount = mService.getTemMailCount(mail);
		List<MailBmk> bList  = mService.printBmk(mailBmk);
		mv.addObject("bList", bList);
		mv.addObject("totalICount", totalICount);
		mv.addObject("totalmCount", totalmCount);
		mv.addObject("totalmRecCount", totalmRecCount);
		mv.addObject("totalmMyCount", totalmMyCount);
		mv.addObject("totalmFileCount", totalmFileCount);
		mv.addObject("readTypeNCount", readTypeNCount);
		mv.addObject("totalAppCount", totalAppCount);
		mv.addObject("totalTemCount", totalTemCount);
		mv.setViewName("mail/mailWriteForm");
		return mv;
	} 
	
	@RequestMapping(value="/mail/bmkWriteView.sw")
	public String bmkWriteView(
			ModelAndView mv
			, HttpServletRequest request
			,@ModelAttribute Mail mail
			, @ModelAttribute MailBmk mailBmk) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		int totalICount = mService.getIMailCount(mail);
		int totalmCount = mService.getMailCount(mail);
		int totalmRecCount = mService.getMailRecCount(mail);
		int totalmMyCount = mService.getMailMyCount(mail);
		int totalmFileCount = mService.getMailFileCount(mail);
		int readTypeNCount = mService.getMailReadCount(mail);
		int totalAppCount = mService.getAppMailCount(mail);
		int totalTemCount = mService.getTemMailCount(mail);
		mailBmk.setMemNum(member.getMemberNum());
		List<MailBmk> bList  = mService.printBmk(mailBmk);
		mv.addObject("bList", bList);
		mv.addObject("totalICount", totalICount);
		mv.addObject("totalmCount", totalmCount);
		mv.addObject("totalmRecCount", totalmRecCount);
		mv.addObject("totalmMyCount", totalmMyCount);
		mv.addObject("totalmFileCount", totalmFileCount);
		mv.addObject("readTypeNCount", readTypeNCount);
		mv.addObject("totalAppCount", totalAppCount);
		mv.addObject("totalTemCount", totalTemCount);
		return "mail/mailMenu";
	}
	//메일 발송 등록
	@RequestMapping(value="/mail/mailRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailRegister(ModelAndView mv, 
			@ModelAttribute Mail mail
			,@ModelAttribute MailFile mailFile
			,@RequestParam("mailSender") String mailSender
			,@RequestParam("mailReceiver") String mailReceiver
			,@RequestParam("mailReferee") String mailReferee
			,@RequestParam(value="uploadFiles",required=false)List<MultipartFile> multipartfile
	         ,HttpServletRequest request) {
		
		try {
			
			MailRec mailRec = new MailRec();
			MailRef mailRef = new MailRef();
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailSender(member.getMail());
			mail.setfStatus("0");
			mail.setMailType("S");
			if(mailSender.equals(mailReceiver)) {
				mail.setMailType("F");
			}
			 if(multipartfile != null) {
			    	mail.setfStatus("1");
			    }
			int mResult = mService.registerMail(mail);
			int recResult = 0;
			int refResult = 0;
			String[] recArr = mailReceiver.split(" ");
			String[] refArr = mailReferee.split(" ");
			
			for(int i = 0; i < recArr.length; i++) {
				mailRec.setMailReceiver(recArr[i]);
				recResult = mService.registerMailRec(mailRec);
			}
			for(int i = 0; i < refArr.length; i++) {
				mailRef.setMailReferee(refArr[i]);
				refResult = mService.registerMailRef(mailRef);
			}
		   
			for(int i= 0; i<multipartfile.size(); i++) {
		    if(multipartfile.size() > 0 && !multipartfile.get(i).getOriginalFilename().equals("")) {
				mail.setfStatus("1");
				   Map<String, String>fileList = saveFile(multipartfile.get(i), request); 
	               String fileName = fileList.get("fileName");
	               String fileRename = fileList.get("fileRename");
	               String filePath = fileList.get("filePath");
	            //첨부파일 테이블 등록
	            mailFile.setMailNo(mail.getMailNo());
	            mailFile.setMailFileName(fileName);
	            mailFile.setMailFileRename(fileRename);
	            mailFile.setMailFilePath(filePath);
	            int fResult = mService.registerMailFile(mailFile);
	         }
		    }
	      
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
	
	//승인메일 발송 등록
		@RequestMapping(value="/mail/mailAppRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
		public ModelAndView mailAppRegister(ModelAndView mv, 
				@ModelAttribute Mail mail
				,@ModelAttribute MailFile mailFile
				,@RequestParam("mailSender") String mailSender
				,@RequestParam("mailReceiver") String mailReceiver
				,@RequestParam("mailReferee") String mailReferee
				,@RequestParam(value="uploadFiles",required=false)List<MultipartFile> multipartfile
				,HttpServletRequest request) {
			
			try {
				MailRec mailRec = new MailRec();
				MailRef mailRef = new MailRef();
				HttpSession session = request.getSession();
				Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
				mail.setMemNum(member.getMemberNum());
				mail.setfStatus("0");
				
				int mResult = mService.registerAppMail(mail);
				int mRecResult = 0;
				int mRefResult = 0;
				String[] recArr = mailReceiver.split(" ");
				String[] refArr = mailReferee.split(" ");
				for(int i = 0; i < recArr.length; i++) {
					mailRec.setMailReceiver(recArr[i]);
					mRecResult = mService.registerAppMailRec(mailRec);
				}
				for(int i = 0; i < refArr.length; i++) {
					mailRef.setMailReferee(refArr[i]);
					mRefResult = mService.registerAppMailRef(mailRef);
				}
				
				for(int i= 0; i<multipartfile.size(); i++) {
				    if(multipartfile.size() > 0 && !multipartfile.get(i).getOriginalFilename().equals("")) {
						mail.setfStatus("1");
						   Map<String, String>fileList = saveFile(multipartfile.get(i), request); 
			               String fileName = fileList.get("fileName");
			               String fileRename = fileList.get("fileRename");
			               String filePath = fileList.get("filePath");
			            //첨부파일 테이블 등록
			            mailFile.setMailNo(mail.getMailNo());
			            mailFile.setMailFileName(fileName);
			            mailFile.setMailFileRename(fileRename);
			            mailFile.setMailFilePath(filePath);
			            int mFileResult = mService.registerAppMailFile(mailFile);
			         }
				    }
				
	
				if(mResult > 0 && mRecResult>0 && mRefResult>0 ) {
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
		public ModelAndView maiMyWriteView(
				ModelAndView mv
				,@ModelAttribute Mail mail
				, @ModelAttribute MailBmk mailBmk
				, HttpServletRequest request
				) {
			
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			mailBmk.setMemNum(member.getMemberNum());
			List<MailBmk> bList  = mService.printBmk(mailBmk);
			int totalICount = mService.getIMailCount(mail);
			int totalmCount = mService.getMailCount(mail);
			int totalmRecCount = mService.getMailRecCount(mail);
			int totalmMyCount = mService.getMailMyCount(mail);
			int totalmFileCount = mService.getMailFileCount(mail);
			int readTypeNCount = mService.getMailReadCount(mail);
			int totalAppCount = mService.getAppMailCount(mail);
			int totalTemCount = mService.getTemMailCount(mail);
			mv.addObject("bList", bList);
			mv.addObject("totalICount", totalICount);
			mv.addObject("totalmCount", totalmCount);
			mv.addObject("totalmRecCount", totalmRecCount);
			mv.addObject("totalmMyCount", totalmMyCount);
			mv.addObject("totalmFileCount", totalmFileCount);
			mv.addObject("readTypeNCount", readTypeNCount);
			mv.addObject("totalAppCount", totalAppCount);
			mv.addObject("totalTemCount", totalTemCount);
			mv.setViewName("mail/mailMyWriteForm");
			return mv;
		
		} 
		//파일 저장
		private Map<String, String> saveFile(MultipartFile file, HttpServletRequest request) {
			Map<String, String> fileMap = new HashMap<String, String>();
			try {
				String filePath = "";
				
				String root = request.getSession().getServletContext().getRealPath("resources"); // 파일 경로 설정
				String savePath = root + "/muploadFiles"; // 저장 폴더 선택
				File folder = new File(savePath); // 폴더 없으면 생성
				if(!folder.exists()) folder.mkdir();
						
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String originalFileName = file.getOriginalFilename(); // 업로드한 파일명
				String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1); // 파일 확장자명
				// 변경할 파일명, 변경할 때에는 SimpleDateFormat 객체를 이용해서 업로드 당시 시각을 파일의 이름으로 바꿔줌
				String mailFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + extensionName;
				filePath = folder + "/" + mailFileName;
				// 두 가지 값을 map에 저장하여 리턴하기
				fileMap.put("filePath", filePath);
				fileMap.put("fileName", originalFileName);
				fileMap.put("fileRename", mailFileName);
				file.transferTo(new File(filePath)); // 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileMap; // 파일 경로 리턴
		}
		
	//임시 저장 등록
	@RequestMapping(value="/mail/mailTemRegister.sw", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailTemporaryRegister (ModelAndView mv, 
			@ModelAttribute Mail mail
			,@ModelAttribute MailFile mailFile
			,@RequestParam("mailSender") String mailSender
			,@RequestParam("mailReceiver") String mailReceiver
			,@RequestParam("mailReferee") String mailReferee
			,@RequestParam(value="uploadFiles",required=false)List<MultipartFile> multipartfile
			,HttpServletRequest request) {
	
	try {
		MailRec mailRec = new MailRec();
		MailRef mailRef = new MailRef();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		mail.setMemNum(member.getMemberNum());
		int mResult = mService.registerTemMail(mail);
		int recResult = 0;
		int refResult = 0;
		String[] recArr = mailReceiver.split(" ");
		String[] refArr = mailReferee.split(" ");
		for(int i = 0; i < recArr.length; i++) {
			mailRec.setMailReceiver(recArr[i]);
			recResult = mService.registerTemMailRec(mailRec);
		}
		for(int i = 0; i < refArr.length; i++) {
			mailRef.setMailReferee(refArr[i]);
			 refResult = mService.registerTemMailRef(mailRef);
		}
	
		for(int i= 0; i<multipartfile.size(); i++) {
		    if(multipartfile.size() > 0 && !multipartfile.get(i).getOriginalFilename().equals("")) {
				mail.setfStatus("1");
				   Map<String, String>fileList = saveFile(multipartfile.get(i), request); 
	               String fileName = fileList.get("fileName");
	               String fileRename = fileList.get("fileRename");
	               String filePath = fileList.get("filePath");
	            //첨부파일 테이블 등록
	            mailFile.setMailNo(mail.getMailNo());
	            mailFile.setMailFileName(fileName);
	            mailFile.setMailFileRename(fileRename);
	            mailFile.setMailFilePath(filePath);
	            int fResult = mService.registerTemMailMyFile(mailFile);
	         }
		    }
		
		if(mResult > 0 && recResult>0 && refResult>0) {
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
	//중요 메일 등록
	@RequestMapping(value="/mail/registerI.sw", method=RequestMethod.GET)
	public ModelAndView registerI(
			ModelAndView mv
			,HttpServletRequest request
			,@ModelAttribute Mail mail
			,@RequestParam("mailNo") int mailNo) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum()); // 사원번호
			mail.setMailNo(mailNo);
			mail.setMailSender(member.getMail());
			mail.setMailReceiver(member.getMail());
			int mResult = mService.regiesteriMail(mail);
			int mRecResult = mService.regiesteriMailRec(mail);
			int mMyResult = mService.regiesteriMailMy(mail);
			int mFileResult = mService.regiesteriMailFile(mail);

			if( mResult>0) {
				mv.setViewName("redirect:/mail/RmailListView.sw");
			}else if (mRecResult>0) {
				mv.setViewName("redirect:/mail/SmailListView.sw");
			} else if(mMyResult>0) {
				mv.setViewName("redirect:/mail/MmailListView.sw");
			} else if(mFileResult>0) {
				mv.setViewName("redirect:/mail/FmailListView.sw");
			}
		
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	//중요메일 취소
	@RequestMapping(value="/mail/cancelI.sw", method=RequestMethod.GET)
	public ModelAndView cancelI(
			ModelAndView mv
			,HttpServletRequest request
			,@ModelAttribute Mail mail
			,@RequestParam("mailNo") int mailNo) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum()); // 사원번호
			mail.setMailNo(mailNo);
			int mResult = mService.removeiMail(mailNo);
//			int mRecResult = mService.removeiMailRec(mail);
//			int mMyResult = mService.removeiMailMy(mail);
//			int mFileResult = mService.removeiMailFile(mail);

			if( mResult>0) {
				mv.setViewName("redirect:/mail/RmailListView.sw");
			}
//			}else if (mRecResult>0) {
//				mv.setViewName("redirect:/mail/SmailListView.sw");
//			} else if(mMyResult>0) {
//				mv.setViewName("redirect:/mail/MmailListView.sw");
//			} else if(mFileResult>0) {
//				mv.setViewName("redirect:/mail/FmailListView.sw");
//			}
		
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	// 즐겨찾는 그룹 등록
	@RequestMapping(value="/mail/registerBmk.sw", method=RequestMethod.POST)
	public ModelAndView registerBmk(
			ModelAndView mv
			,HttpServletRequest request
			,@RequestParam(value="bmkSubject") String bmkSubject
			) {
		
		try {
			MailBmk mailBmk = new MailBmk();
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mailBmk.setMemNum(member.getMemberNum()); // 사원번호
			mailBmk.setBmkSubject(bmkSubject);

			int result = 0;
			String[] bmkArr = request.getParameterValues("arrText"); // [0]정은진 / [1]권지혜 / [2]김아름
			for(int i = 0; i < bmkArr.length; i++) {
				String [] results = bmkArr[i].split(" ");
				mailBmk.setDivision(results[0]);
				mailBmk.setBmkMemNum(results[1]);
				mailBmk.setBmkName(results[2]);
				mailBmk.setRank(results[3]);
				mailBmk.setBmkAddr(results[4]);
				
				result = mService.registerMailBmk(mailBmk);
			}
			if(result>0) {
				mv.addObject("msg", "등록 성공");
				mv.setViewName("redirect:/mail/RmailListView.sw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	
	
	// 메일 리스트 조회
	@RequestMapping( value="/mail/{param}mailListView.sw", method= RequestMethod.GET )
	public ModelAndView mailListView(ModelAndView mv
		, @PathVariable("param") String mailCategory
		, HttpServletRequest request
		, @RequestParam(value="page", required = false) Integer page
		, @ModelAttribute Mail mail
		, @ModelAttribute MailRec mailRec
		, @ModelAttribute MailBmk mailBmk
		
		) {
		try {
			mv.addObject("myCondition", "approval");
			mv.addObject("listCondition", mailCategory);
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			mailRec.setMailNo(mail.getMailNo());
			int currentPage = (page != null) ? page : 1;
			int totalICount = mService.getIMailCount(mail);
			int totalmCount = mService.getMailCount(mail);
			int totalmRecCount = mService.getMailRecCount(mail);
			int totalmMyCount = mService.getMailMyCount(mail);
			int totalmFileCount = mService.getMailFileCount(mail);
			int readTypeNCount = mService.getMailReadCount(mail);
			int totalAppCount = mService.getAppMailCount(mail);
			int totalTemCount = mService.getTemMailCount(mail);
			int totalCount = mService.getTemMailCount(mail);
		
			int cTotalCount = 0;
			PageInfo pi = null;
			
			
			List<Mail> mList = null;
			List<Mail> mRecList = null;
			List<Mail> mMyList = null;
			List<Mail> mFileList = null;
			List<MailRec> cList = mService.printMailRecList(mailRec);
			mailBmk.setMemNum(member.getMemberNum());
			List<MailBmk> bList  = mService.printBmk(mailBmk);
			
			String viewName = "mail/mailList";
			int mResult = 0;
			int mRecResult = 0;
			int mMyResult = 0;
			int mFileResult = 0;
			
			// 보낸 편지함일 때
			if(mailCategory.equals("R")) {
				pi = Pagination.getPageInfo(currentPage, totalmCount);
				mList = mService.printMail(mail, pi);
				mv.addObject("mList", mList);
				cTotalCount = mService.getReceiverCount(mail);
				mv.addObject("cTotalCount", cTotalCount);
				//중요메일 등록
				mResult = mService.regiesteriMail(mail);
				
			//받은 편지함일 때
			}else if(mailCategory.equals("S")) {
				 pi = Pagination.getPageInfo(currentPage, totalmRecCount);
				mRecList = mService.printMailRec(mail, pi);
				//중요메일 등록
				mRecResult = mService.regiesteriMailRec(mail);
				mv.addObject("mList", mRecList);

			//내게 쓴 편지함 일 때
			}else if(mailCategory.equals("M")){
				pi = Pagination.getPageInfo(currentPage, totalmMyCount);
				mMyList = mService.printMailMy(mail, pi);
				cList = mService.printMailRecList(mailRec);
				//중요메일 등록
				mMyResult = mService.regiesteriMailMy(mail);
				mv.addObject("mList", mMyList);
				
			//파일 편지함일 때
			} else if (mailCategory.equals("F")){
				pi = Pagination.getPageInfo(currentPage, totalmFileCount);
				mFileList = mService.printMailFile(mail, pi);
				//중요메일 등록
				mFileResult = mService.regiesteriMailFile(mail);
				mv.addObject("mList", mFileList);
				
			}
			
			mv.addObject("pi", pi);
			
			mv.addObject("mailCategory", mailCategory);
			mv.setViewName(viewName);
			mv.addObject("bList", bList);
			mv.addObject("cList", cList);
			
			mv.addObject("totalCount", totalCount);
			mv.addObject("totalICount", totalICount);
			mv.addObject("totalmCount", totalmCount);
			mv.addObject("totalmRecCount", totalmRecCount);
			mv.addObject("totalmMyCount", totalmMyCount);
			mv.addObject("totalmFileCount", totalmFileCount);
			mv.addObject("readTypeNCount", readTypeNCount);
			mv.addObject("totalAppCount", totalAppCount);
			mv.addObject("totalTemCount", totalTemCount);
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
			,@ModelAttribute Mail mail
			, @ModelAttribute MailBmk mailBmk) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalCount = mService.getTemMailCount(mail);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
			mailBmk.setMemNum(member.getMemberNum());
			List<MailBmk> bList  = mService.printBmk(mailBmk);
			List<Mail> tList = mService.printTemMail(mail, pi);
			int totalICount = mService.getIMailCount(mail);
			int totalmCount = mService.getMailCount(mail);
			int totalmRecCount = mService.getMailRecCount(mail);
			int totalmMyCount = mService.getMailMyCount(mail);
			int totalmFileCount = mService.getMailFileCount(mail);
			int readTypeNCount = mService.getMailReadCount(mail);
			int totalAppCount = mService.getAppMailCount(mail);
			int totalTemCount = mService.getTemMailCount(mail);
			if(!tList.isEmpty()) {
				mv.addObject("tList", tList);
				mv.setViewName("mail/mailTemList");
				mv.addObject("pi", pi);
			} else {
				mv.addObject("msg", "임시 저장 조회 실패");
				mv.setViewName("common/errorPage");
			}
			mv.addObject("bList", bList);
			mv.addObject("totalCount", totalCount);
			mv.addObject("totalICount", totalICount);
			mv.addObject("totalmCount", totalmCount);
			mv.addObject("totalmRecCount", totalmRecCount);
			mv.addObject("totalmMyCount", totalmMyCount);
			mv.addObject("totalmFileCount", totalmFileCount);
			mv.addObject("readTypeNCount", readTypeNCount);
			mv.addObject("totalAppCount", totalAppCount);
			mv.addObject("totalTemCount", totalTemCount);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
		return mv;
		
	}
	// 즐겨찾는 그룹 추가 목록
	@ResponseBody
	@RequestMapping(value = "/modal/mailBmklist.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String modalBmkList(
			HttpServletRequest request
		) {
		MailBmk mailBmk = new MailBmk();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); 
		mailBmk.setMemNum(member.getMemberNum());
		List<MailBmk> bList = mService.printBmk(mailBmk);
		if(!bList.isEmpty()) {
			return new Gson().toJson(bList);
		}
		return null;
		
	}
	//승인메일 목록 조회
	@RequestMapping( value="/mail/mailAppListView.sw", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView mailAppListView(ModelAndView mv
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			,@ModelAttribute Mail mail
			, @ModelAttribute MailBmk mailBmk
			) {
		
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalAppCount = mService.getAppMailCount(mail);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalAppCount);
			List<Mail> aList = mService.printAppMail(mail, pi);
			mailBmk.setMemNum(member.getMemberNum());
			List<MailBmk> bList  = mService.printBmk(mailBmk);
			int totalICount = mService.getIMailCount(mail);
			int totalmCount = mService.getMailCount(mail);
			int totalmRecCount = mService.getMailRecCount(mail);
			int totalmMyCount = mService.getMailMyCount(mail);
			int totalmFileCount = mService.getMailFileCount(mail);
			int readTypeNCount = mService.getMailReadCount(mail);
			int totalTemCount = mService.getTemMailCount(mail);
			if(!aList.isEmpty()) {
				mv.addObject("aList", aList);
				mv.setViewName("mail/mailAppList");
				mv.addObject("pi", pi);
			} else {
				mv.addObject("msg", "승인 메일 조회 실패");
				mv.setViewName("common/errorPage");
			}
			mv.addObject("bList", bList);
			mv.addObject("totalICount", totalICount);
			mv.addObject("totalmCount", totalmCount);
			mv.addObject("totalmRecCount", totalmRecCount);
			mv.addObject("totalmMyCount", totalmMyCount);
			mv.addObject("totalmFileCount", totalmFileCount);
			mv.addObject("readTypeNCount", readTypeNCount);
			mv.addObject("totalAppCount", totalAppCount);
			mv.addObject("totalTemCount", totalTemCount);
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
				return mv;
		
		
	}
	//즐겨찾는 메일 목록
	@RequestMapping( value="/mail/mailIListView.sw", method= {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView mailIListView (ModelAndView mv
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			,@ModelAttribute Mail mail
			, @ModelAttribute MailBmk mailBmk) {
		
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
			mail.setMemNum(member.getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			mailBmk.setMemNum(member.getMemberNum());
			List<MailBmk> bList  = mService.printBmk(mailBmk);
			int totalICount = mService.getIMailCount(mail);
			int totalmCount = mService.getMailCount(mail);
			int totalmRecCount = mService.getMailRecCount(mail);
			int totalmMyCount = mService.getMailMyCount(mail);
			int totalmFileCount = mService.getMailFileCount(mail);
			int readTypeNCount = mService.getMailReadCount(mail);
			int totalAppCount = mService.getAppMailCount(mail);
			int totalTemCount = mService.getTemMailCount(mail);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalICount);
			List<Mail>iList = mService.printIMail(mail, pi);
			if(!iList.isEmpty()) {
				mv.addObject("iList", iList);
				mv.setViewName("mail/mailIList");
				mv.addObject("pi", pi);
			} else {
				mv.addObject("msg", "승인 메일 조회 실패");
				mv.setViewName("common/errorPage");
			}
			mv.addObject("bList", bList);
			mv.addObject("totalICount", totalICount);
			mv.addObject("totalmCount", totalmCount);
			mv.addObject("totalmRecCount", totalmRecCount);
			mv.addObject("totalmMyCount", totalmMyCount);
			mv.addObject("totalmFileCount", totalmFileCount);
			mv.addObject("readTypeNCount", readTypeNCount);
			mv.addObject("totalAppCount", totalAppCount);
			mv.addObject("totalTemCount", totalTemCount);
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
	// 임시 저장 검색
	@RequestMapping( value="/mail/TmailSearch.sw", method = RequestMethod.GET)
	public ModelAndView mailSearchTemList(
			ModelAndView mv
			,@ModelAttribute Search search
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			, @ModelAttribute Mail mail) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기 // 세션 값에서 사원번호 가져오기
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalTemCount = mService.getSearchTemMailCount(search);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalTemCount);
			mv.addObject("search", search);
			List<Mail>searchTemList = mService.printSearchTemMail(search,pi);
			mv.addObject("tList", searchTemList);
			mv.addObject("totalTemCount", totalTemCount);
			mv.setViewName( "mail/mailTemList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
				return mv;

		
	}
	//승인 메일 검색
	@RequestMapping( value="/mail/AmailSearch.sw", method = RequestMethod.GET)
	public ModelAndView mailSearchAppList(
			ModelAndView mv
			,@ModelAttribute Search search
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			, @ModelAttribute Mail mail) {
		try {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기 // 세션 값에서 사원번호 가져오기
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum());
			mail.setMailReceiver(member.getMail());
			mail.setMailSender(member.getMail());
			int currentPage = (page != null) ? page : 1;
			int totalAppCount = mService.getSearchAppMailCount(search);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalAppCount);
			mv.addObject("search", search);
			List<Mail>searchAppList = mService.printSearchAppMail(search,pi);
			mv.addObject("aList", searchAppList);
			mv.addObject("totalAppCount", totalAppCount);
			mv.setViewName( "mail/mailAppList");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		
				return mv;
			
			
		}
	//메일 상세 조회
		@RequestMapping(value="/mail/{param}mailDetailView.sw", method = {RequestMethod.GET, RequestMethod.POST})
		public ModelAndView mailDetailView( 
			ModelAndView mv
			, @RequestParam("mailNo") int mailNo 
			,@PathVariable("param") String mailCategory
			, HttpServletRequest request) {
			try {
				
				HttpSession session = request.getSession();
				Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
				MailBmk mailBmk = new MailBmk();
				
				Mail mail = mService.printOneMail(mailNo);
				List<MailRec> mailRec = mService.printOneMailRec(mailNo);
				List<MailRef> mailRef = mService.printOneMailRef(mailNo);
				List<MailFile> mailFile = mService.printOneMailFile(mailNo);
				mailBmk.setMemNum(member.getMemberNum());
				List<MailBmk> bList  = mService.printBmk(mailBmk);
				
				int totalICount = mService.getIMailCount(mail);
				int totalmCount = mService.getMailCount(mail);
				int totalmRecCount = mService.getMailRecCount(mail);
				int totalmMyCount = mService.getMailMyCount(mail);
				int totalmFileCount = mService.getMailFileCount(mail);
				int readTypeNCount = mService.getMailReadCount(mail);
				int totalAppCount = mService.getAppMailCount(mail);
				int totalTemCount = mService.getTemMailCount(mail);
				int count = mService.viewCountMail(mailNo);
				if(count > 0) {
					mail.setReadType("1");
				}
				if(mail != null && mailRec!= null && mailRef!= null) {
					
					mv.addObject("mail", mail);
					mv.addObject("mailRec", mailRec);
					mv.addObject("mailRef", mailRef);
					mv.addObject("mailFile", mailFile);
					mv.setViewName("mail/mailDetail");
					
				
				} else {
					mv.addObject("msg", "메일 상세 조회 실패");
					mv.setViewName("common/errorPage");
				}	
				mv.addObject("totalICount", totalICount);
				mv.addObject("totalmCount", totalmCount);
				mv.addObject("totalmRecCount", totalmRecCount);
				mv.addObject("totalmMyCount", totalmMyCount);
				mv.addObject("totalmFileCount", totalmFileCount);
				mv.addObject("readTypeNCount", readTypeNCount);
				mv.addObject("totalAppCount", totalAppCount);
				mv.addObject("totalTemCount", totalTemCount);
				mv.addObject("bList", bList);
			} catch (Exception e) {
				mv.addObject("msg", e.toString());
				mv.setViewName("common/errorPage");
			}
		
				return mv;
				
			}
		
				//임시저장 상세 조회
				@RequestMapping(value="/mail/mailTemDetailView.sw", method = RequestMethod.GET)
				public ModelAndView mailTemDetailView( 
					ModelAndView mv
					, @RequestParam("mailNo") int mailNo
					, @ModelAttribute MailBmk mailBmk
					, HttpServletRequest request) {
					try {
						HttpSession session = request.getSession();
						Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
						Mail mail = mService.printOneTemMail(mailNo);
						List<MailRec> mailRec = mService.printOneTemMailRec(mailNo);
						List<MailRef> mailRef = mService.printOneTemMailRef(mailNo);
						List<MailFile> mailFile = mService.printOneTemMailFile(mailNo);
						mService.viewCountMail(mailNo);
						int totalICount = mService.getIMailCount(mail);
						int totalmCount = mService.getMailCount(mail);
						int totalmRecCount = mService.getMailRecCount(mail);
						int totalmMyCount = mService.getMailMyCount(mail);
						int totalmFileCount = mService.getMailFileCount(mail);
						int readTypeNCount = mService.getMailReadCount(mail);
						int totalAppCount = mService.getAppMailCount(mail);
						int totalTemCount = mService.getTemMailCount(mail);
						mailBmk.setMemNum(member.getMemberNum());
						List<MailBmk> bList  = mService.printBmk(mailBmk);
						if(mail != null && mailRec != null && mailRef!=null) {
							mv.addObject("mail", mail);
							mv.addObject("mailRec", mailRec);
							mv.addObject("mailRef", mailRef);
							mv.addObject("mailFile", mailFile);
							mv.setViewName("mail/mailTemDetail");
						} else {
							mv.addObject("msg", "메일 상세 조회 실패");
							mv.setViewName("common/errorPage");
						}
						mv.addObject("bList", bList);
						mv.addObject("totalICount", totalICount);
						mv.addObject("totalmCount", totalmCount);
						mv.addObject("totalmRecCount", totalmRecCount);
						mv.addObject("totalmMyCount", totalmMyCount);
						mv.addObject("totalmFileCount", totalmFileCount);
						mv.addObject("readTypeNCount", readTypeNCount);
						mv.addObject("totalAppCount", totalAppCount);
						mv.addObject("totalTemCount", totalTemCount);
					} catch (Exception e) {
						mv.addObject("msg", e.toString());
						mv.setViewName("common/errorPage");
					}
				
						return mv;
						
					}
				//승인메일 상세 조회
				@RequestMapping(value="/mail/mailAppDetailView.sw", method = {RequestMethod.GET, RequestMethod.POST})
				public ModelAndView mailAppDetailView(
						ModelAndView mv 
						, @RequestParam("mailNo") int mailNo
						, @ModelAttribute MailBmk mailBmk
						, HttpServletRequest request) {
					try {
						HttpSession session = request.getSession();
						Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
						Mail mail = mService.printOneAppMail(mailNo);
						List<MailRec> mailRec = mService.printOneAppMailRec(mailNo);
						List<MailRef> mailRef= mService.printOneAppMailRef(mailNo);
						List<MailFile> mailFile = mService.printOneAppMailFile(mailNo);
						int totalICount = mService.getIMailCount(mail);
						int totalmCount = mService.getMailCount(mail);
						int totalmRecCount = mService.getMailRecCount(mail);
						int totalmMyCount = mService.getMailMyCount(mail);
						int totalmFileCount = mService.getMailFileCount(mail);
						int readTypeNCount = mService.getMailReadCount(mail);
						int totalAppCount = mService.getAppMailCount(mail);
						int totalTemCount = mService.getTemMailCount(mail);
						mailBmk.setMemNum(member.getMemberNum());
						List<MailBmk> bList  = mService.printBmk(mailBmk);
						mService.viewCountMail(mailNo);
						if(mail != null && mailRec != null && mailRef!=null && mailFile != null) {
							mv.addObject("mail", mail);
							mv.addObject("mailRec", mailRec);
							mv.addObject("mailRef", mailRef);
							mv.addObject("mailFile", mailFile);
							mv.setViewName("mail/mailAppDetail");
						} else {
							mv.addObject("msg", "메일 상세 조회 실패");
							mv.setViewName("common/errorPage");
						}mv.addObject("bList", bList);
						mv.addObject("totalICount", totalICount);
						mv.addObject("totalmCount", totalmCount);
						mv.addObject("totalmRecCount", totalmRecCount);
						mv.addObject("totalmMyCount", totalmMyCount);
						mv.addObject("totalmFileCount", totalmFileCount);
						mv.addObject("readTypeNCount", readTypeNCount);
						mv.addObject("totalAppCount", totalAppCount);
						mv.addObject("totalTemCount", totalTemCount);
					} catch (Exception e) {
						mv.addObject("msg", e.toString());
						mv.setViewName("common/errorPage");
					}
							return mv;
					
				}
				//즐겨찾는 메일 상세 조회
				@RequestMapping(value="/mail/mailIDetailView.sw", method = {RequestMethod.GET, RequestMethod.POST})
				public ModelAndView mailIDetailView (
						ModelAndView mv 
						, @RequestParam("mailNo") int mailNo
						, @ModelAttribute MailBmk mailBmk
						, HttpServletRequest request
						) {
					try {
						HttpSession session = request.getSession();
						Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
						Mail mail = mService.printOneIMail(mailNo);
						
						List<MailRec> mailRec = mService.printOneIMailRec(mailNo);
						List<MailRef> mailRef = mService.printOneIMailRef(mailNo);
						List<MailFile> mailFile = mService.printOneIMailFile(mailNo);
						int totalICount = mService.getIMailCount(mail);
						int totalmCount = mService.getMailCount(mail);
						int totalmRecCount = mService.getMailRecCount(mail);
						int totalmMyCount = mService.getMailMyCount(mail);
						int totalmFileCount = mService.getMailFileCount(mail);
						int readTypeNCount = mService.getMailReadCount(mail);
						int totalAppCount = mService.getAppMailCount(mail);
						int totalTemCount = mService.getTemMailCount(mail);
						mailBmk.setMemNum(member.getMemberNum());
						List<MailBmk> bList  = mService.printBmk(mailBmk);
						mService.viewCountMail(mailNo);
						if(mail != null) {
							mv.addObject("mail", mail);
							mv.setViewName("mail/mailIDetail");
						} else {
							mv.addObject("msg", "메일 상세 조회 실패");
							mv.setViewName("common/errorPage");
						}
						mv.addObject("bList", bList);
						mv.addObject("totalICount", totalICount);
						mv.addObject("totalmCount", totalmCount);
						mv.addObject("totalmRecCount", totalmRecCount);
						mv.addObject("totalmMyCount", totalmMyCount);
						mv.addObject("totalmFileCount", totalmFileCount);
						mv.addObject("readTypeNCount", readTypeNCount);
						mv.addObject("totalAppCount", totalAppCount);
						mv.addObject("totalTemCount", totalTemCount);
					} catch (Exception e) {
						mv.addObject("msg", e.toString());
						mv.setViewName("common/errorPage");
					}
							return mv;
				}
				//임시 저장 수정페이지
				@RequestMapping(value="/mail/temModifyView.sw", method = RequestMethod.GET)
				public  ModelAndView mailTemModifyView(
						ModelAndView mv 
						, @RequestParam("mailNo") int mailNo
						, @ModelAttribute MailBmk mailBmk
						, HttpServletRequest request) {
					try {
						HttpSession session = request.getSession();
						Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
						Mail mail = mService.printOneTemMail(mailNo);
						List<MailRec> mailRec = mService.printOneTemMailRec(mailNo);
						List<MailRef> mailRef = mService.printOneTemMailRef(mailNo);
						List<MailFile> mailFile = mService.printOneTemMailFile(mailNo);
						int totalICount = mService.getIMailCount(mail);
						int totalmCount = mService.getMailCount(mail);
						int totalmRecCount = mService.getMailRecCount(mail);
						int totalmMyCount = mService.getMailMyCount(mail);
						int totalmFileCount = mService.getMailFileCount(mail);
						int readTypeNCount = mService.getMailReadCount(mail);
						int totalAppCount = mService.getAppMailCount(mail);
						int totalTemCount = mService.getTemMailCount(mail);
						mailBmk.setMemNum(member.getMemberNum());
						List<MailBmk> bList  = mService.printBmk(mailBmk);
						if(mail != null && mailRec != null && mailRef!=null && mailFile != null) {
							mv.addObject("mail", mail);
							mv.addObject("mailRec", mailRec);
							mv.addObject("mailRef", mailRef);
							mv.addObject("mailFile", mailFile);
							mv.setViewName("mail/modifyTemView");
						} else {
							mv.addObject("msg", "수정 실패");
							mv.setViewName ("common/errorPage");
						}
						mv.addObject("bList", bList);
						mv.addObject("totalICount", totalICount);
						mv.addObject("totalmCount", totalmCount);
						mv.addObject("totalmRecCount", totalmRecCount);
						mv.addObject("totalmMyCount", totalmMyCount);
						mv.addObject("totalmFileCount", totalmFileCount);
						mv.addObject("readTypeNCount", readTypeNCount);
						mv.addObject("totalAppCount", totalAppCount);
						mv.addObject("totalTemCount", totalTemCount);
					} catch (Exception e) {
						mv.addObject("msg", e.toString());
						mv.setViewName ("common/errorPage");
					}
					return mv;
					
					
				}
				//임시저장 수정
				@RequestMapping(value ="/mail/updateTemMail.sw", method = RequestMethod.POST)
				public ModelAndView mailTemUpdate(
						ModelAndView mv
						, @ModelAttribute Mail mail
						, @ModelAttribute MailRec mailRec
						, @ModelAttribute MailRef mailRef
						, @ModelAttribute MailFile mailFile
						, @RequestParam(value="reloadFile", required=false)List<MultipartFile> multipartfile
						, HttpServletRequest request) {
					
					try {
						for(int i= 0; i<multipartfile.size(); i++) {
						    if(multipartfile.size() > 0 && !multipartfile.get(i).getOriginalFilename().equals("")) {
						    	deleteFile(mailFile.getMailFilePath(), request);
								   Map<String, String>fileList = saveFile(multipartfile.get(i), request); 
					               String fileName = fileList.get("fileName");
					               String fileRename = fileList.get("fileRename");
					               String filePath = fileList.get("filePath");
					            //첨부파일 테이블 등록
					            mailFile.setMailNo(mail.getMailNo());
					            mailFile.setMailFileName(fileName);
					            mailFile.setMailFileRename(fileRename);
					            mailFile.setMailFilePath(filePath);
					         }
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
					return "mail/mailList";
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

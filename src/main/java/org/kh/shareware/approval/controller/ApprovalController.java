package org.kh.shareware.approval.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.shareware.approval.domain.AppDocument;
import org.kh.shareware.approval.domain.AppFile;
import org.kh.shareware.approval.domain.AppForm;
import org.kh.shareware.approval.domain.AppReference;
import org.kh.shareware.approval.domain.Approval;
import org.kh.shareware.approval.service.ApprovalService;
import org.kh.shareware.common.PageInfo;
import org.kh.shareware.common.Pagination;
import org.kh.shareware.common.Search;
import org.kh.shareware.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ApprovalController {
	
	@Autowired
	private ApprovalService aService;
	
	// 문서함으로 이동(기안/결재/참조/임시)
	@RequestMapping(value = "/approval/{param}ListView.sw")
	public String docListView(Model model, @PathVariable("param") String parameter
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page
			, @RequestParam(value="docStatus", required = false) String docStatus
			, @ModelAttribute AppDocument appDoc) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", parameter);
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		appDoc.setDocStatus(docStatus);
		appDoc.setMemNum(member.getMemberNum());
		int currentPage = (page != null) ? page : 1;
		int totalCount = aService.getListCount(appDoc);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<AppDocument> dList = aService.printAll(appDoc, pi);
		model.addAttribute("dList", dList);
		model.addAttribute("pi", pi);
		model.addAttribute("type", parameter);
		return "approval/" + parameter + "List";
	}
	
	// 기안 문서함 검색
	@RequestMapping(value = "/approval/draftSearch.sw")
	public ModelAndView draftSearchList(Model model, ModelAndView mv
			, @ModelAttribute Search search
			, HttpServletRequest request
			, @RequestParam(value="page", required = false) Integer page) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", "draft");
		try {
			HttpSession session = request.getSession();
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum()); // 세션 값에서 사원번호 가져오기
			int currentPage = (page != null) ? page : 1;
			int totalCount = aService.getSearchDraftCount(search);
			PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
			List<AppDocument> searchDraft = aService.printSearchDraft(search, pi);
			if(searchDraft != null) {
				mv.addObject("dList", searchDraft);
				mv.addObject("search", search);
				mv.addObject("pi", pi);
				mv.addObject("type", "draft");
				mv.setViewName("approval/draftList");
			}else {
				mv.addObject("msg", "검색 실패");
				mv.addObject("loc", "/approval/draftListView.sw");
				mv.setViewName("common/msg");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 문서 양식 전체 조회
	@ResponseBody
	@RequestMapping(value = "/modal/appForm/list.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String appFormList() {
		List<AppForm> fList = aService.printAllForm();
		if(!fList.isEmpty()) {
			return new Gson().toJson(fList);
		}
		return null;
	}
	
	// 문서 작성 페이지
	@RequestMapping(value = "/approval/docWriteView.sw")
	public ModelAndView docWriteView(ModelAndView mv, Model model
			, @RequestParam(value = "formNo") int formNo
			, @ModelAttribute AppForm form) {
		try {
			model.addAttribute("myCondition", "approval");
			model.addAttribute("listCondition", "draft");
			Date nowTime = new Date(); // 현재 날짜 가져오기
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			model.addAttribute("nowTime", sf.format(nowTime));
			form = aService.printForm(formNo);
			if(form != null) {
				mv.addObject("form", form);
				mv.setViewName("approval/docWrite");
			}else {
				mv.addObject("msg", "문서 양식 조회 실패");
				mv.setViewName("common/errorPage");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 결재 요청
	@RequestMapping(value = "/approval/save{param}.sw", method = RequestMethod.POST)
	public ModelAndView docRegister(ModelAndView mv
			, @ModelAttribute AppDocument appDoc
			, @ModelAttribute Approval app
			, @ModelAttribute AppReference ref
			, @ModelAttribute AppFile file
			, @ModelAttribute AppForm form
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, @RequestParam(value="appMemNum") String appMemNum
			, @RequestParam(value="refMemNum") String refMemNum
			, HttpServletRequest request
			, @PathVariable("param") String parameter) {
		try {
			appDoc.setFormNo(form.getFormNo()); // 문서 양식 번호
			if(parameter.equals("Doc")) {
				appDoc.setDocStatus("대기");
			}else if(parameter.equals("Temporary")) {
				appDoc.setDocStatus("임시");
			}
			int dResult = aService.registerDoc(appDoc); // 문서 등록
			int aResult = 0; // 결재자 등록 결과 변수 선언
			int rResult = 0; // 참조자 등록 결과 변수 선언
			int fResult = 0; // 파일 첨부 등록 결과 변수 선언
			// 결재자
			String[] appArray = appMemNum.split(","); // 배열에 결재자 넣기
			for(int i = 0; i < appArray.length; i++) {
				app.setMemNum(appArray[i]); // 결재자 사원번호
				app.setAppLevel(i+1); // 결재자 순번
				if(parameter.equals("Doc")) {
					app.setAppStatus("대기");
				}else if(parameter.equals("Temporary")) {
					app.setAppStatus("임시");
				}
				aResult = aService.registerApp(app); // 결재자 등록
			}
			// 참조자
			if(!refMemNum.isEmpty()) { // 참조자가 있는 경우에만
				String[] refArray = refMemNum.split(","); // 배열에 참조자 넣기
				for(int i = 0; i < refArray.length; i++) {
					ref.setMemNum(refArray[i]); // 참조자 사원번호
					if(parameter.equals("Doc")) {
						ref.setRefStatus("참조");
					}else if(parameter.equals("Temporary")) {
						ref.setRefStatus("임시");
					}
					rResult = aService.registerRef(ref); // 참조자 등록
				}
			}else {
				rResult = 1;
			}
			// 파일 첨부
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				// input type이 file인 경우 Object(객체)에 담게 되므로 String인 NoticeFilePath에 저장하기 위한 작업
				// input 태그의 name 값을 Notice의 noticeFilePath로 하면 안됨(MultipartFile은 String이 아니기 때문)
				HashMap<String, String> fileMap = saveFile(uploadFile, request); // 업로드한 파일
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
				if(filePath != null && !filePath.equals("")) {
					file.setFileName(uploadFile.getOriginalFilename());
					file.setFileReName(fileRename);
					file.setFilePath(filePath);
					fResult = aService.registerFile(file);
				}
			}else {
				fResult = 1;
			}
			if(dResult < 1) {
				mv.addObject("msg", "문서 등록 실패");
			}else if(aResult < 1) {
				mv.addObject("msg", "결재자 등록 실패");
			}else if(rResult < 1) {
				mv.addObject("msg", "참조자 등록 실패");
			}else if(fResult < 1) {
				mv.addObject("msg", "파일 등록 실패");
			}else {
				mv.addObject("msg", "등록 성공");
			}
			mv.addObject("loc", "/approval/draftListView.sw");
			mv.setViewName("common/msg");
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 휴가 신청서 조회(잔여 연차)
	@ResponseBody
	@RequestMapping(value = "/approval/leaveDocSearch.sw", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String leaveDocSearch(@RequestParam(value = "memberNum") String memberNum) {
		String leaveLeft = aService.printOneLeaveDoc(memberNum);
		if(!leaveLeft.equals("")) {
			return new Gson().toJson(leaveLeft);
		}
		return null;
	}
	
	// 파일 저장
	private HashMap<String, String> saveFile(MultipartFile file, HttpServletRequest request) {
		String filePath = "";
		HashMap<String, String> fileMap = new HashMap<String, String>();
		String root = request.getSession().getServletContext().getRealPath("resources"); // 파일 경로 설정
		String savePath = root + "\\auploadFiles"; // 저장 폴더 선택
		File folder = new File(savePath); // 폴더 없으면 생성
		if(!folder.exists()) folder.mkdir();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename(); // 업로드한 파일명
		String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1); // 파일 확장자명
		// 변경할 파일명, 변경할 때에는 SimpleDateFormat 객체를 이용해서 업로드 당시 시각을 파일의 이름으로 바꿔줌
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + extensionName;
		filePath = folder + "\\" + renameFileName;
		// 두 가지 값을 map에 저장하여 리턴하기
		fileMap.put("filePath", filePath);
		fileMap.put("fileName", renameFileName);
		try {
			file.transferTo(new File(filePath)); // 파일 저장
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileMap; // 파일 경로 리턴
	}
	
}

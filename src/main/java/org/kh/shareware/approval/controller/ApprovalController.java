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
			, @ModelAttribute AppDocument appDoc
			, @ModelAttribute Approval app
			, @ModelAttribute AppReference ref) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", parameter);
		HttpSession session = request.getSession();
	Member member = (Member) session.getAttribute("loginUser"); // 세션 값 가져오기
		if(parameter.equals("tem")) {
			docStatus = "임시";
		}else if(docStatus == null) {
			docStatus = "전체";
		}
		int currentPage = (page != null) ? page : 1;
		int totalCount = 0; 
		PageInfo pi = null;
		List<AppDocument> dList = null;
		if(parameter.equals("draft") || parameter.equals("tem")) { // 기안 문서함, 임시 저장함
			appDoc.setDocStatus(docStatus);
			appDoc.setMemNum(member.getMemberNum());
			totalCount = aService.getListCount(appDoc);
			pi = Pagination.getPageInfo(currentPage, totalCount);
			dList = aService.printAll(appDoc, pi);
		}else if(parameter.equals("ref")) { // 참조 문서함
			ref.setDocStatus(docStatus);
			ref.setMemNum(member.getMemberNum());
			totalCount = aService.getListCountRef(ref);
			pi = Pagination.getPageInfo(currentPage, totalCount);
			dList = aService.printAllRefDoc(ref, pi);
		}
		model.addAttribute("dList", dList);
		model.addAttribute("pi", pi);
		model.addAttribute("type", parameter);
		model.addAttribute("docStatus", docStatus);
		return "approval/" + parameter + "List";
	}
	
	// 문서함 검색(기안/결재/참조/임시)
	@RequestMapping(value = "/approval/{param}Search.sw")
	public ModelAndView searchList(Model model, ModelAndView mv
			, @ModelAttribute Search search
			, HttpServletRequest request
			, @PathVariable("param") String parameter
			, @RequestParam(value="page", required = false) Integer page) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", parameter);
		if(parameter.equals("tem")) {
			search.setType("임시");
		}else if(parameter.equals("draft")) {
			search.setType("기안");
		}
		try {
			HttpSession session = request.getSession();
			search.setMemberNum(((Member)session.getAttribute("loginUser")).getMemberNum()); // 세션 값에서 사원번호 가져오기
			int currentPage = (page != null) ? page : 1;
			PageInfo pi = null;
			List<AppDocument> searchDoc = null;
			if(parameter.equals("draft") || parameter.equals("tem")) {
				int totalCount = aService.getSearchDraftCount(search);
				pi = Pagination.getPageInfo(currentPage, totalCount);
				searchDoc = aService.printSearchDraft(search, pi);
			}else if(parameter.equals("ref")) { // 참조 문서함
				int totalCount = aService.getSearchRefCount(search);
				pi = Pagination.getPageInfo(currentPage, totalCount);
				searchDoc = aService.printSearchRef(search, pi);
			}
			if(searchDoc != null) {
				mv.addObject("dList", searchDoc);
				mv.addObject("search", search);
				mv.addObject("pi", pi);
				mv.addObject("type", parameter);
				mv.setViewName("approval/" + parameter + "List");
			}else {
				mv.addObject("msg", "검색 실패");
				mv.addObject("loc", "/approval/" + parameter + "ListView.sw");
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
	
	// 결재 요청, 임시 저장
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
				if(parameter.equals("Doc")) {
					mv.addObject("msg", "결재 요청 성공");
					mv.addObject("loc", "/approval/draftListView.sw");
				}else if(parameter.equals("Temporary")) {
					mv.addObject("msg", "임시 저장 성공");
					mv.addObject("loc", "/approval/temListView.sw");
				}
			}
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
	public String leaveDocSearch(@RequestParam(value = "memberNum") String memberNum
			,HttpServletRequest request) {
		String leaveLeft = aService.printOneLeaveDoc(memberNum);
		HttpSession session = request.getSession();
		String totalLeave = ((Member)session.getAttribute("loginUser")).getBreakTotal(); // 세션 값에서 총 연차수 가져오기
		leaveLeft = (leaveLeft == null) ? totalLeave : leaveLeft;
			return new Gson().toJson(leaveLeft);
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
	
	// 문서 상세 페이지
	@RequestMapping(value = "/approval/detail.sw")
	private ModelAndView docDetailView(ModelAndView mv, Model model
			, @RequestParam("docNo") int docNo
			, @RequestParam("type") String type) {
		model.addAttribute("myCondition", "approval");
		model.addAttribute("listCondition", type);
		Date nowTime = new Date(); // 현재 날짜 가져오기
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("nowTime", sf.format(nowTime));
		try {
			AppDocument appDoc = aService.printOneDoc(docNo); // 문서 상세 조회
			List<Approval> aList = aService.printAllApp(docNo); // 결재자 조회
			List<AppReference> rList = aService.printAllRef(docNo); // 참조자 조회
			AppFile appFile = aService.printOneFile(docNo); // 파일 조회
			if(appDoc != null && !aList.isEmpty()) {
				mv.addObject("appDoc", appDoc);
				mv.addObject("aList", aList);
				mv.addObject("rList", rList);
				mv.addObject("appFile", appFile);
				mv.addObject("type", type);
				if(!type.equals("tem")) { // 기안/결재/참조
					mv.setViewName("approval/docDetail");
				}else if(type.equals("tem")){ // 임시 저장함
					mv.setViewName("approval/docUpdate");
				}
			}else {
				mv.addObject("msg", "문서 상세 조회 실패");
				mv.addObject("loc", "/approval/" + type + "ListView.sw");
				mv.setViewName("common/msg");
			}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 상신 취소, 삭제
	@RequestMapping(value = "/approval/cancle.sw")
	private String docRemove(Model model, @RequestParam("docNo") int docNo, @RequestParam("type") String type) {
		try {
			int result = aService.removeDoc(docNo);
			if(result > 0) {
				if(type.equals("draft")) {
					model.addAttribute("msg", "상신 취소 성공");
				}else if(type.equals("tem")){
					model.addAttribute("msg", "삭제 성공");
				}
				model.addAttribute("loc", "/approval/" + type + "ListView.sw");
				return "common/msg";
			}else {
				if(type.equals("draft")) {
					model.addAttribute("msg", "상신 취소 실패");
				}else if(type.equals("tem")){
					model.addAttribute("msg", "삭제 실패");
				}
				model.addAttribute("loc", "/approval/" + type + "ListView.sw");
				return "common/msg";
			}
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 임시 저장 수정(결재 요청, 임시 저장)
	@RequestMapping(value = "/approval/update{param}.sw", method = RequestMethod.POST)
	private ModelAndView docUpdate(ModelAndView mv
			, @ModelAttribute AppDocument appDoc
			, @ModelAttribute Approval app
			, @ModelAttribute AppReference ref
			, @ModelAttribute AppFile file
			, @ModelAttribute AppForm form
			, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
			, @RequestParam(value="appMemNum", required=false) String appMemNum
			, @RequestParam(value="refMemNum", required=false) String refMemNum
			, HttpServletRequest request
			, @PathVariable("param") String parameter) {
		try {
			if(parameter.equals("Doc")) {
				appDoc.setDocStatus("대기");
			}else if(parameter.equals("Temporary")) {
				appDoc.setDocStatus("임시");
			}
			int dResult = aService.modifyDoc(appDoc); // 문서 수정
			int aResult = 0; // 결재자 등록 결과 변수 선언
			int rResult = 0; // 참조자 등록 결과 변수 선언
			int fResult = 0; // 파일 첨부 등록 결과 변수 선언
			// 결재자
			if(!appMemNum.equals("")) {
				aService.removeApp(appDoc.getDocNo());
				String[] appArray = appMemNum.split(","); // 배열에 결재자 넣기
				for(int i = 0; i < appArray.length; i++) {
					app.setDocNo(appDoc.getDocNo());
					app.setMemNum(appArray[i]); // 결재자 사원번호
					app.setAppLevel(i+1); // 결재자 순번
					if(parameter.equals("Doc")) {
						app.setAppStatus("대기");
					}else if(parameter.equals("Temporary")) {
						app.setAppStatus("임시");
					}
					aResult = aService.registerApp(app); // 결재자 등록
				}
			}else {
				if(parameter.equals("Doc")) {
					app.setAppStatus("대기");
					aService.modifyApp(app); // 결재자 상태 변경(임시->대기)
				}
				aResult = 1;
			}
			// 참조자
			if(!refMemNum.equals("")) {
				List<AppReference> rList = aService.printAllRef(appDoc.getDocNo()); // 참조자 조회
				if(!rList.isEmpty()) {
					aService.removeRef(appDoc.getDocNo());
				}
				String[] refArray = refMemNum.split(","); // 배열에 참조자 넣기
				for(int i = 0; i < refArray.length; i++) {
					ref.setDocNo(appDoc.getDocNo());
					ref.setMemNum(refArray[i]); // 참조자 사원번호
					if(parameter.equals("Doc")) {
						ref.setRefStatus("참조");
					}else if(parameter.equals("Temporary")) {
						ref.setRefStatus("임시");
					}
					rResult = aService.registerRef(ref); // 참조자 등록
				}
			}else {
				if(parameter.equals("Doc")) {
					ref.setRefStatus("참조");
					aService.modifyRef(ref); // 참조자 상태 변경(임시->참조)
				}
				rResult = 1;
			}
			if(reloadFile != null && !reloadFile.getOriginalFilename().equals("")) {
				// 파일이 있으면 기존 파일 삭제
				AppFile appFile = aService.printOneFile(appDoc.getDocNo()); // 파일 조회
				if(appFile != null) {
					aService.removeFile(appDoc.getDocNo());
					deleteFile(appFile.getFilePath(), request);
				}
				// 새로운 파일 다시 업로드
				HashMap<String, String> fileMap = saveFile(reloadFile, request); // 업로드한 파일
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
				if(filePath != null && !filePath.equals("")) {
					file.setDocNo(appDoc.getDocNo());
					file.setFileName(reloadFile.getOriginalFilename());
					file.setFileReName(fileRename);
					file.setFilePath(filePath);
					fResult = aService.registerFile(file);
				}
			}else {
				fResult = 1;
			}
			if(dResult < 1) {
				mv.addObject("msg", "문서 수정 실패");
			}else if(aResult < 1) {
				mv.addObject("msg", "결재자 등록 실패");
			}else if(rResult < 1) {
				mv.addObject("msg", "참조자 등록 실패");
			}else if(fResult < 1) {
				mv.addObject("msg", "파일 등록 실패");
			}else {
				if(parameter.equals("Doc")) {
					mv.addObject("msg", "결재 요청 성공");
					mv.addObject("loc", "/approval/draftListView.sw");
				}else if(parameter.equals("Temporary")) {
					mv.addObject("msg", "임시 저장 성공");
					mv.addObject("loc", "/approval/temListView.sw");
				}
			}
			mv.setViewName("common/msg");
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 파일 삭제
	public void deleteFile(String filePath, HttpServletRequest request) {
		File deleteFile = new File(filePath); // 저장 폴더 선택
		if(deleteFile.exists()) { // 파일이 존재하면
			deleteFile.delete(); // 파일 삭제
		}
	}
	
	// 임시 저장 수정 화면에서 선택했던 파일 삭제
	 @RequestMapping(value="/approval/fileDelete.sw", method=RequestMethod.GET)
	 public String fileDelete(ModelAndView mv
				, @RequestParam(value = "filePath", required = false) String filePath 
				, @RequestParam(value = "docNo", required = false) int docNo 
				, HttpServletRequest request){
				deleteFile(filePath, request);
				aService.removeFile(docNo);
				return "redirect:/approval/detail.sw?docNo=" + docNo + "&type=tem";
		 }
}

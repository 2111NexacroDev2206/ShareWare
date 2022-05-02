<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${type == 'tem' }">
	<title>임시 저장 수정</title>
</c:if>
<c:if test="${type == 'rej' }">
	<title>반려 문서 재상신</title>
</c:if>
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h1 id="h-title">${appDoc.formName }</h1>
		<form id="form" action="/approval/updateDoc.sw" method="post" enctype="multipart/form-data" onsubmit="return nullChk()">
			<input type="hidden" name="formNo" value="${appDoc.formNo }" readonly>
			<table border="1" id="table">
				<tr>
					<td>문서번호</td>
					<c:if test="${type == 'tem' }">
						<td>${appDoc.docNo }</td><input type="hidden" name="docNo" value="${appDoc.docNo }" readonly>
					</c:if>
					<c:if test="${type == 'rej' }">
						<td><input type="hidden" name="docNo" value="${appDoc.docNo }" readonly></td>
					</c:if>
					<td rowspan="3" style="writing-mode: vertical-rl;">결재</td>
					<td>담당</td>
					<td id="r-app0">${aList[0].rank }</td>
					<td id="r-app1">${aList[1].rank }</td>
					<td id="r-app2">${aList[2].rank }</td>
				</tr>
				<tr>
					<td>기안일</td>
					<td>${nowTime }<input type="hidden" value="${nowTime }" name="docDate" readonly></td>
					<td>${appDoc.docDate }</td>
					<td align="center">${aList[0].appDate }<button type="button" onclick="appBtn('app');">선택</button></td>
					<td>${aList[1].appDate }</td>
					<td>${aList[2].appDate }</td>
				</tr>
				<tr>
					<td>기안자</td>
					<td>${appDoc.memName }<input type="hidden" value="${loginUser.memberNum }" name="memNum" readonly></td>
					<td>${appDoc.memName }</td>
					<td id="name-app0">${aList[0].memberName }</td><input type="hidden" id="num-app" name="appMemNum" readonly>
					<td id="name-app1">${aList[1].memberName }</td>
					<td id="name-app2">${aList[2].memberName }</td>
				</tr>
				<tr>
					<td>참조자</td>
					<td colspan="5" id="ref-list">
						<c:forEach items="${rList }" var="appRef" varStatus="index">
							<c:choose>
								<c:when test="${!index.last}">
									${appRef.division } ${appRef.memberName } ${appRef.rank },
								</c:when>
								<c:when test="${index.last}">
									${appRef.division } ${appRef.memberName } ${appRef.rank }
								</c:when>
	    					</c:choose>
						</c:forEach>
					</td><input type="hidden" id="num-ref" name="refMemNum" readonly>
					<td><button id="app-btn" type="button" onclick="appBtn('ref');">+</button></td>
				</tr>
				<tr id="tr-title">
					<td>제목</td>
					<td colspan="6"><input type="text" name="docTitle" id="td-title" value="${appDoc.docTitle }"></td>
				</tr>
				<c:set var="formName" value="${appDoc.formName}" />
				<c:if test="${formName eq '휴가신청서'}">
	                <tr>
	                    <td>휴가 종류</td>
	                    <td colspan="6">
	                    	<select id="leaveType" name="leaveType">
	                            <option value="">선택</option>
	                            <option value="연차">연차</option>
	                            <option value="반차">반차</option>
	                            <option value="특별휴가">특별휴가</option>
	                            <option value="공가">공가</option>
	                            <option value="병가">병가</option>
	                        </select>
	                    </td>
	                </tr>
	                <tr>
	                    <td>휴가 기간</td>
	                    <td colspan="6" id="td-leave-date">
	                    	<input type="date" name="leaveStart" onchange="leaveStartDate(event)" id="startDate" value="${appDoc.leaveStart }">
	                        <span id="tilde">~</span>
	                        <input type="date" name="leaveEnd" id="endDate" value="${appDoc.leaveEnd }" onchange="leaveEndDate(event)"> 
	                        <span id="leaveTime" style="display: none;"><input type="radio" name="leaveTime" id="am" value="오전">오전 <input type="radio" name="leaveTime" id="pm" value="오후">오후 </span> 
                        	휴가 일수 : <span id="s-leaveDay">${appDoc.leaveDay }</span><input type="hidden" name="leaveDay" id="i-leaveDay" value="${appDoc.leaveDay }" readonly>
	                    </td>
	                </tr>
	                <tr>
	                    <td>연차 일수</td>
	                    <td colspan="6" id="td-leave-day">
	                        	잔여 연차 : <input type="text" name="leaveLeft" id="left-leave" value="${appDoc.leaveLeft}" readonly>
	                        	신청 연차 : <input type="text" name="leaveApply" id="apply-leave" value="${appDoc.leaveApply}" readonly>
	                    </td>
	                </tr>
	                <tr>
	                    <td>휴가 사유</td>
	                    <td colspan="6" id="td-leave-reason"><textarea cols="50" rows="10" name="docContent">${appDoc.docContent}</textarea></td>
	                </tr>
				</c:if>
				<c:if test="${appDoc.formName ne '휴가신청서'}">
					<tr>
						<td colspan="7" align="center">내용</td>
					</tr>
					<tr>
						<td colspan="7">
							<textarea name="docContent">${appDoc.docContent }</textarea>
						</td>
					</tr>
				</c:if>
			</table>
			<p>파일 첨부
			<c:if test="${type == 'tem' }">
				<input type="file" id="file-input" name="reloadFile">
				<span id="file-val">${appFile.fileName }</span> <button id="btn-delete" type="button" onclick="deleteFile('${appFile.filePath}',${appFile.docNo} );">X</button>
			</c:if>
			<c:if test="${type == 'rej' }">
				<input type="file" id="file-input" name="uploadFile">
			</c:if>
			<input type="button" value="결재 요청" onclick="docSave()">
			<c:if test="${type == 'tem' }">
				<input type="button" value="임시 저장" onclick="temSave()">
			</c:if>
			<c:if test="${type == 'rej' }">
				<input type="button" value="임시 저장" onclick="rejTemSave()">
			</c:if>
			<input type="button" id="btn-cancel" value="삭제">
			<input type="button" value="취소" onclick="location.href='/approval/temListView.sw'">
		</form>
	</div>
	<jsp:include page="appModal.jsp"></jsp:include> <!-- 결재자/참조자 선택 모달 -->
	<script>
		// 반려 문서 재상신
		if("${type}" == "rej") {
			$("#form").attr("action", "/approval/saveRejDoc.sw");
		}
	
		// 선택한 파일 삭제	
		if($("#file-val").text() == "") {
			$("#btn-delete").css("display","none");
		}
		function deleteFile(filePath, docNo){
			location.href="/approval/fileDelete.sw?filePath="+filePath+"&docNo="+docNo;
		}
	
		// 결재 요청 확인창
		function docSave() {
			var result = confirm("결재 요청하시겠습니까?");
			if(result == true) {
				$("#form").submit();
			}
		}
	
		// 유효성 체크
		function nullChk() {
			if($("#title").val() == "") {
				alert("제목을 입력해주세요.");
				$("#title").focus();
				return false;
			}
		}
		
		// CKEditor
		if("${appDoc.formName }" !== "휴가신청서"){
			CKEDITOR.replace( 'docContent', {
				height: 350
			} );
		}
		
		// 임시 저장
		function temSave() {
			$("#form").attr("action", "/approval/updateTemporary.sw");
			$("#form").submit();
		}
		
		// 반려 문서 임시 저장
		function rejTemSave() {
			$("#form").attr("action", "/approval/saveRejTem.sw");
			$("#form").submit();
		}
		
		// 삭제 확인
		$("#btn-cancel").click(function() { // 삭제 클릭 시 확인창 뜨고 확인 누르면 삭제 실행
			var result = confirm("삭제하시겠습니까?");
			if(result == true) {
				location.href = '/approval/cancle.sw?type=${type}&docNo=${appDoc.docNo}'
			}
		})
		
		// 휴가신청서
		if("${appDoc.formName }" === "휴가신청서"){
			$("#tr-title").css("display", "none"); // 제목 행 숨기기
		    var leaveStart = new Date($("#startDate").val()); // 휴가 시작일 변수 선언
		    var leaveEnd = new Date($("#endDate").val());   // 휴가 종료일 변수 선언
		    var leaveDay = $("#i-leaveDay").val();   // 휴가 일수 변수 선언
		    var totalLeave = 0; // 잔여 연차
		    var memberNum = "${loginUser.memberNum}"; // 로그인 한 유저의 사원번호
		    var breakTotal = "${loginUser.breakTotal}"; // 로그인 한 유저의 총 연차수
			$("#leaveType").val("${appDoc.leaveType }").prop("selected", true); // 휴가 종류 불러와서 선택 값으로 넣기
			if("${appDoc.leaveType }" === "반차") { // 휴가 종류가 반차인 경우
				$("#endDate").css("display", "none"); // 휴가 종료일 숨기기
	            $("#tilde").css("display", "none"); // 휴가 시작일과 종료일 사이 '~' 숨기기
	            $("#leaveTime").css("display", "inline-flex"); // 오전/오후 보이기
				if("${appDoc.leaveTime }" === "오전") {
					$("#am").prop("checked", true);
				}else if("${appDoc.leaveTime }" === "오후") {
					$("#pm").prop("checked", true);
				}
			}
		 	
		    function leaveStartDate(e) { // 휴가 시작일 값 날짜화
		        leaveStart = new Date(e.target.value);
		        calLeaveDate();
		        chkLeave();
		    }
		    function leaveEndDate(e) { // 휴가 종료일 값 날짜화
		        leaveEnd = new Date(e.target.value);
		        calLeaveDate();
		        chkLeave();
		    }
		    function calLeaveDate() { // 휴가 날짜 차이 계산(연차, 반차인 경우에만)
		        if($("#leaveType").val() == "반차") { // 반차인 경우
		            leaveDay = 0.5;
		        }else {
		            if(leaveStart !== 0 && leaveEnd !== 0){
		                var dateDiff = leaveEnd.getTime() - leaveStart.getTime();
		                leaveDay = Math.abs(dateDiff / (1000 * 3600 * 24) + 1);
		            }else {
		            	leaveDay = 0;
		            }
		        }
		        setLeaveDay(leaveDay);
		        viewLeaveDay(leaveDay);
		    }
		    $("#leaveType").change(function() { // 휴가 종류 선택에 따라 처리하는 함수
		    	$.ajax({ // 잔여 연차 조회
			 		url : "/approval/leaveDocSearch.sw",
			 		type : "get",
			 		data : { "memberNum" : memberNum },
			 		success : function(leaveLeft) {
			 			totalLeave = leaveLeft;
			 			$("#left-leave").val(totalLeave);
			 		},
			 		error : function() {
			 			console.log("잔여 연차 조회 실패");
			 		}
			 	})
		        var leaveType = $("#leaveType").val();
		        $("#td-title").val(leaveType + " 신청합니다.");
		        if($(this).val() == "반차") {
		            leaveDay = 0.5;
		            $("#leaveTime").css("display", "inline-flex"); // 오전/오후 보이기
		            $(":radio[name='leaveTime'][value='오전']").prop("checked", true); // 휴가 시간 라디오 버튼 오전 자동으로 체크
		            $("#endDate").css("display", "none"); // 휴가 종료일 숨기기
		            $("#tilde").css("display", "none"); // 휴가 시작일과 종료일 사이 '~' 숨기기
		            setLeaveDay(leaveDay);
		            viewLeaveDay(leaveDay);
		        }else{
		        	calLeaveDate();
		            $("#leaveTime").css("display", "none"); // 오전 오후 숨기기
		            $(":radio[name='leaveTime']").prop("checked", false); // 휴가 시간 라디오 버튼 체크 해제
		            $("#endDate").css("display", "inline-flex"); // 휴가 종료일 보이기
		            $("#tilde").css("display", "inline-flex"); // 휴가 시작일과 종료일 사이 '~' 보이기
		            setLeaveDay(leaveDay);
		            viewLeaveDay(leaveDay);
		        }
		    });
		    function viewLeaveDay(leaveDay) { // 휴가 종류에 따라 연차 일수 표시
		        if($("#leaveType").val() == "연차" || $("#leaveType").val() == "반차") { // 반차 또는 연차인 경우
		            $("#apply-leave").val(leaveDay);
		            $("#left-leave").val(totalLeave - leaveDay);
		        }else {
		            $("#left-leave").val(totalLeave);
		            $("#apply-leave").val(0);
		        }
		    }
		    function setLeaveDay(leaveDay) { // 휴가 일수 표시 및 value 값 넣기
		        $("#s-leaveDay").text(leaveDay);
		        $("#i-leaveDay").val(leaveDay);
		    }
		    function chkLeave(){ // 신청 연차가 잔여 연차보다 클 경우 alert창 띄우고 종료일 초기화
			    if(leaveDay > totalLeave) { 
			    	if($("#leaveType").val() == "연차" || $("#leaveType").val() == "반차"){
			    		alert("신청 연차 수가 잔여 연차 수를 초과했습니다.");
			    		$("#endDate").val("");
			    		leaveDay = 0;
			    	}
			    	setLeaveDay(leaveDay);
			        viewLeaveDay(leaveDay);
			    }
		    }
		};
	</script>
</body>
</html>
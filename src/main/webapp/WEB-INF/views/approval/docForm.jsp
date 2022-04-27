<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 양식</title>
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h1 id="h-title">문서 양식</h1>
		<form id="form" action="/approval/docWrite.sw" method="post" enctype="multipart/form-data" onsubmit="return nullChk()">
			<input type="hidden" value=${form.formNo } name='formNo' readonly>
			<table border="1" id="table">
				<tr>
					<td>문서번호</td>
					<td></td>
					<td rowspan="3" style="writing-mode: vertical-rl;">결재</td>
					<td>담당</td>
					<td id="d-app0"></td>
					<td id="d-app1"></td>
					<td id="d-app2"></td>
				</tr>
				<tr>
					<td>기안일</td>
					<td>${nowTime }<input type="hidden" value="${nowTime }" name="docDate" readonly></td>
					<td></td>
					<td align="center"><button type="button" onclick="appBtn('app');">선택</button></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>기안자</td>
					<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="memNum" readonly></td>
					<td>${loginUser.memberName }</td>
					<td id="name-app0"></td><input type="hidden" id="num-app" name="appMemNum" readonly>
					<td id="name-app1"></td>
					<td id="name-app2"></td>
				</tr>
				<tr>
					<td>참조자</td>
					<td colspan="5" id="ref-list"></td><input type="hidden" id="num-ref" name="refMemNum" readonly>
					<td><button id="app-btn" type="button" onclick="appBtn('ref');">+</button></td>
				</tr>
				<tr id="tr-title">
					<td>제목</td>
					<td colspan="6"><input type="text" name="docTitle" id="td-title"></td>
				</tr>
				<c:set var="formName" value="${form.formName}" />
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
	                        <input type="date" name="leaveStart" onchange="leaveStartDate(event)" id="startDate">
	                        <span id="tilde">~</span>
	                        <input type="date" name="leaveEnd" id="endDate" onchange="leaveEndDate(event)"> 
	                        <span id="leaveTime" style="display: none;"><input type="radio" name="leaveTime" value="오전">오전 <input type="radio" name="leaveTime" value="오후">오후 </span> 
	                        	휴가 일수 : <span id="s-leaveDay"></span><input type="hidden" name="leaveDay" id="i-leaveDay" readonly>
	                    </td>
	                </tr>
	                <tr>
	                    <td>연차 일수</td>
	                    <td colspan="6" id="td-leave-day">
	                        	잔여 연차 : <span id="left-leave"></span>
	                        	신청 연차 : <span id="apply-leave"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>휴가 사유</td>
	                    <td colspan="6" id="td-leave-reason"><textarea cols="50" rows="10" name="docContent"></textarea></td>
	                </tr>
				</c:if>
				<c:if test="${formName ne '휴가신청서'}">
					<tr>
						<td colspan="7">
							<textarea rows="5" cols="5" name="docContent">${form.formContent }</textarea>
						</td>
					</tr>
				</c:if>
			</table>
			<p>파일 첨부
			<input type="file" id="file-input" name="uploadFile">
			<input type="submit" value="결재 요청">
			<input type="button" value="임시 저장">
			<input type="button" value="취소">
		</form>
	</div>
	<jsp:include page="appModal.jsp"></jsp:include> <!-- 결재자 선택 모달 -->
	<script>
		// 유효성 체크
		function nullChk() {
			if($("#title").val() == "") {
				alert("제목을 입력해주세요.");
				$("#title").focus();
				return false;
			}else if($("#content").val() == "") {
				alert("내용을 입력해주세요.");
				$("#content").focus();
				return false;
			}else if($("#num-app").val() == "") {
				alert("결재자를 선택해주세요.");
				return false;
			}
		}
		
		// CKEditor
		if("${form.formName}" !== "휴가신청서"){
			CKEDITOR.replace( 'docContent' );
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서 양식</title>
<link href="/resources/css/approval/appWrite-style.css" rel="stylesheet">
<script src="https://cdn.ckeditor.com/4.18.0/full-all/ckeditor.js"></script>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h1 id="h-title">문서 양식</h1>
		<form id="form" action="/approval/saveDoc.sw" method="post" enctype="multipart/form-data" onsubmit="return nullChk()">
			<input type="hidden" value=${form.formNo } name='formNo' readonly>
			<input type="hidden" id="num-app" name="appMemNum" readonly>
			<input type="hidden" id="num-ref" name="refMemNum" readonly>
			<table id="table">
				<tr class="tr-s">
					<td class="td-1" rowspan="2">문서번호</td>
					<td class="td-2" rowspan="2"></td>
					<td class="td-3" rowspan="5" style="writing-mode: vertical-rl;">결재</td>
					<td class="td-4">담당</td>
					<td class="td-4" id="r-app0"></td>
					<td class="td-4" id="r-app1"></td>
					<td class="td-4" id="r-app2"></td>
				</tr>
				<tr class="tr-s">
					<td class="td-5" rowspan="3"></td>
					<td align="center" rowspan="3"><button type="button" onclick="appBtn('app');">선택</button></td>
					<td class="td-5" rowspan="3"></td>
					<td class="td-5" rowspan="3"></td>
				</tr>
				<tr class="tr-m">
					<td class="td-1">기안일</td>
					<td class="td-2">${nowTime }<input type="hidden" value="${nowTime }" name="docDate" readonly></td>
				</tr>
				<tr class="tr-s">
					<td class="td-1" rowspan="2">기안자</td>
					<td class="td-2" rowspan="2">${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="memNum" readonly></td>
				</tr>
				<tr>
					<td class="td-4">${loginUser.memberName }</td>
					<td class="td-4" id="name-app0"></td>
					<td class="td-4" id="name-app1"></td>
					<td class="td-4" id="name-app2"></td>
				</tr>
				<tr class="tr-m">
					<td class="td-1">참조자</td>
					<td colspan="5" id="ref-list"></td>
					<td><button id="app-btn" type="button" onclick="appBtn('ref');">+</button></td>
				</tr>
				<tr id="tr-title" class="tr-m">
					<td class="td-1">제목</td>
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
	                        	잔여 연차 : <input type="text" name="leaveLeft" id="left-leave" readonly>
	                        	신청 연차 : <input type="text" name="leaveApply" id="apply-leave" readonly>
	                    </td>
	                </tr>
	                <tr>
	                    <td>휴가 사유</td>
	                    <td colspan="6" id="td-leave-reason"><textarea cols="50" rows="10" name="docContent"></textarea></td>
	                </tr>
				</c:if>
				<c:if test="${formName ne '휴가신청서'}">
					<tr class="tr-m">
						<td colspan="7" align="center" style="background-color: rgb(240, 240, 240);">내용</td>
					</tr>
					<tr>
						<td colspan="7">
							<textarea name="docContent">${form.formContent }</textarea>
						</td>
					</tr>
				</c:if>
			</table>
			<p>파일 첨부
			<input type="file" id="file-input" name="uploadFile">
			<div class="div-btn">
				<input type="button" value="결재 요청" onclick="docSave()">
				<input type="button" value="임시 저장" onclick="temSave()">
				<input type="button" value="취소" onclick="location.href='/approval/draftListView.sw'">
			</div>
		</form>
	</div>
	<jsp:include page="appModal.jsp"></jsp:include> <!-- 결재자/참조자 선택 모달 -->
	<script>
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
			}else if($("#num-app").val() == "") {
				alert("결재자를 선택해주세요.");
				return false;
			}
		}
		
		// CKEditor
		if("${form.formName}" !== "휴가신청서"){
			CKEDITOR.replace( 'docContent', {
				height: 350,
				removePlugins: "exportpdf"
			} );
		}
		
		// 임시 저장
		function temSave() {
			$("#form").attr("action", "/approval/saveTemporary.sw");
			$("#form").submit();
		}
	</script>
</body>
</html>
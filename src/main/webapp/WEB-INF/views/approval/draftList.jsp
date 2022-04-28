<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서함</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h2 id="h-title">기안 문서함</h2>
		<a>전체</a>
		<a>대기</a>
		<a>진행</a>
		<a>완료</a>
		<a>반려</a>
		<button id="app-btn">결재 상신</button>
		<table border="1">
			<tr>
				<th>기안일</th>
				<th>문서양식</th>
				<th>제목</th>
				<th>문서번호</th>
				<th>결재상태</th>
			</tr>
			<c:forEach items="${dList }" var="appDoc">
				<tr>
					<td>${appDoc.docDate }</td>
					<td>${appDoc.formName }</td>
					<c:url var="aDetail" value="/approval/detail.sw">
						<c:param name="docNo" value="${appDoc.docNo }"></c:param>
					</c:url>
					<td><a href="${aDetail }">${appDoc.docTitle }</a></td>
					<td>${appDoc.docNo }</td>
					<td>${appDoc.docStatus }</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="appPaging.jsp"></jsp:include> <!-- 페이징 -->
		<div class="m-search">
			<form action="/approval/draftSearch.sw" method="get">
				<select class="s-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="all">전체</option>
					<option value="docDate">기안일</option>
					<option value="formName">문서양식</option>
					<option value="docTitle">제목</option>
					<option value="docNo">문서번호</option>
				</select>
				<div class="s-input">
					<input type="text" id="s-value" name="searchValue" class="s-text">
					<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
				</div>
			</form>
		</div>
	</div>
	<!-- 문서 양식 선택 모달 -->
	<div class="m-appSel-wrap" id="appSelModal">
		<div class="m-appSel">
			<div class="m-header">
				<span class="m-header-title" id="header">문서양식 선택</span>
			</div>
			<div class="m-body">
				<div class="m-search">
					<select class="s-selForm" id="selectBox">
					</select>
				</div>
			</div>
			<div class="m-footer">
				<span class="m-btn confirm" id="confirm">확인</span>
				<span class="m-btn cancel" id="cancel">취소</span>
			</div>
		</div>
	</div>
</body>
<script>
	// 문서 양식 목록 조회
	$.ajax({
		url : "/modal/appForm/list.sw",
		type : "get",
		success : function(sList) {
			$.each(sList, function(index, item) {
				$("#selectBox").append("<option value=" + item.formNo + ">" + item.formName + "</option>")
			})
		},
		error : function() {
			alert("문서 양식 조회 실패");
		}
	});
	// 결재 상신 버튼 클릭
	$("#app-btn").click(function() {
		$("#appSelModal").css('display', 'flex').hide().fadeIn();
	});
	$("#confirm").click(function(){
	    var formNo = $("#selectBox option:checked").val();
	    location.replace("/approval/docWriteView.sw?formNo=" + formNo);
	});
	$("#cancel").click(function(){
	    modalClose();
    });
	function modalClose(){
	    $("#appSelModal").fadeOut();
	}
</script>
</html>
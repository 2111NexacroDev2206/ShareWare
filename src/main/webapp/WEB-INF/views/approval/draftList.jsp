<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서함</title>
<link href="/resources/css/appList-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h2 id="h-title">기안 문서함</h2>
		<span class="type ${docStatus eq '전체' ? 'active' : ''}"><a href="/approval/${type }ListView.sw">전체</a></span>
		<span class="type ${docStatus eq '대기' ? 'active' : ''}"><a href="/approval/${type }ListView.sw?docStatus=대기">대기</a></span>
		<span class="type ${docStatus eq '진행' ? 'active' : ''}"><a href="/approval/${type }ListView.sw?docStatus=진행">진행</a></span>
		<span class="type ${docStatus eq '완료' ? 'active' : ''}"><a href="/approval/${type }ListView.sw?docStatus=완료">완료</a></span>
		<span class="type ${docStatus eq '반려' ? 'active' : ''}"><a href="/approval/${type }ListView.sw?docStatus=반려">반려</a></span>
		<button id="app-btn">결재 상신</button>
		<table class="t-List">
			<tr>
				<th class="th-1">기안일</th>
				<th class="th-1">문서양식</th>
				<th class="th-2">제목</th>
				<th class="th-1">문서번호</th>
				<th class="th-1">결재상태</th>
			</tr>
			<c:forEach items="${dList }" var="appDoc">
				<tr>
					<td>${appDoc.docDate }</td>
					<td>${appDoc.formName }</td>
					<c:url var="aDetail" value="/approval/detail.sw?type=${type }&docStatus=${appDoc.docStatus }">
						<c:param name="docNo" value="${appDoc.docNo }"></c:param>
					</c:url>
					<td><a href="${aDetail }">${appDoc.docTitle }</a></td>
					<td>${appDoc.docNo }</td>
					<c:if test="${appDoc.docStatus == '대기'}">
						<td><font color="black">${appDoc.docStatus }</font></td>
					</c:if>
					<c:if test="${appDoc.docStatus == '진행'}">
						<td><font color="blue">${appDoc.docStatus }</font></td>
					</c:if>
					<c:if test="${appDoc.docStatus == '완료'}">
						<td><font color="gray">${appDoc.docStatus }</font></td>
					</c:if>
					<c:if test="${appDoc.docStatus == '반려'}">
						<td><font color="red">${appDoc.docStatus }</font></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="appPaging.jsp"></jsp:include> <!-- 페이징 -->
		<div class="l-search">
			<form action="/approval/${type}Search.sw" method="get">
				<select class="l-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="all">전체</option>
					<option value="docDate">기안일</option>
					<option value="formName">문서양식</option>
					<option value="docTitle">제목</option>
					<option value="docNo">문서번호</option>
				</select>
				<div class="l-input">
					<input type="text" id="s-value" name="searchValue" class="l-text">
					<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="formModal.jsp"></jsp:include> <!-- 문서 양식 선택 -->
</body>
</html>
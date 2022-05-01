<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 문서함</title>
<link href="/resources/css/appModal-style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h2 id="h-title">결재 문서함</h2>
		<a href="/approval/${type }ListView.sw">전체</a>
		<a href="/approval/${type }ListView.sw?docStatus=대기">대기</a>
		<a href="/approval/${type }ListView.sw?docStatus=완료">완료</a>
		<a href="/approval/${type }ListView.sw?docStatus=반려">반려</a>
		<table border="1">
			<tr>
				<th>기안일</th>
				<th>문서양식</th>
				<th>제목</th>
				<th>기안자</th>
				<th>결재상태</th>
			</tr>
			<c:forEach items="${dList }" var="appDoc">
				<tr>
					<td>${appDoc.docDate }</td>
					<td>${appDoc.formName }</td>
					<c:url var="aDetail" value="/approval/detail.sw?type=${type }">
						<c:param name="docNo" value="${appDoc.docNo }"></c:param>
					</c:url>
					<td><a href="${aDetail }">${appDoc.docTitle }</a></td>
					<td>${appDoc.memName }</td>
					<td>${appDoc.docStatus }</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="appPaging.jsp"></jsp:include> <!-- 페이징 -->
		<div class="m-search">
			<form action="/approval/${type}Search.sw" method="get">
				<select class="s-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="all">전체</option>
					<option value="docDate">기안일</option>
					<option value="formName">문서양식</option>
					<option value="docTitle">제목</option>
					<option value="memName">기안자</option>
				</select>
				<div class="s-input">
					<input type="text" id="s-value" name="searchValue" class="s-text">
					<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
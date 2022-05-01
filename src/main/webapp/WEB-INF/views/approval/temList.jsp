<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 저장함</title>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h2 id="h-title">임시 저장함</h2>
		<button id="app-btn">결재 상신</button>
		<table border="1">
			<tr>
				<th>생성일</th>
				<th>문서양식</th>
				<th>제목</th>
				<th>문서상태</th>
			</tr>
			<c:forEach items="${dList }" var="appDoc">
				<tr>
					<td>${appDoc.docDate }</td>
					<td>${appDoc.formName }</td>
					<c:url var="aDetail" value="/approval/detail.sw?type=${type }">
						<c:param name="docNo" value="${appDoc.docNo }"></c:param>
					</c:url>
					<td><a href="${aDetail }">${appDoc.docTitle }</a></td>
					<td>${appDoc.docStatus }</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="appPaging.jsp"></jsp:include> <!-- 페이징 -->
		<div class="m-search">
			<form action="/approval/${type}Search.sw" method="get">
				<select class="s-select" id="s-condition" name="searchCondition" style="text-align: left; width: 80px;">
					<option value="all">전체</option>
					<option value="docDate">생성일</option>
					<option value="formName">문서양식</option>
					<option value="docTitle">제목</option>
				</select>
				<div class="s-input">
					<input type="text" id="s-value" name="searchValue" class="s-text">
					<input type="submit" id="btn-search" class="i-search" value="&#xf002;">
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="formModal.jsp"></jsp:include> <!-- 문서 양식 선택 -->
</body>
</html>
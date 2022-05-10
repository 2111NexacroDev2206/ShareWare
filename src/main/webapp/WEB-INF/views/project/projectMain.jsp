<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 메인 화면 </title>
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
		<div class="s-container">
		<div>
			<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${wList }" var="work" varStatus="status">
				<tr>
					<td>${pi.totalCount - (pi.currentPage - 1)*pi.docLimit - status.index}</td>
					<c:url var="wDetail" value="/project/workDetail.sw">
						<c:param name="workNo" value="${work.workNo }"></c:param>
						<c:param name="projectNo" value="${projectNo }"></c:param>
					</c:url>
					<td><a href="${wDetail }">${work.workTitle }</a></td>
					<td>${work.workDate }</td>
					<td>${work.workWriter }</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
		</div>
		<br><br>
		<div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${iList }" var="important" varStatus="status">
				<tr>
					<td>${pi.totalCount - (pi.currentPage - 1)*pi.docLimit - status.index}</td>
					<c:url var="iDetail" value="/project/importantDetail.sw">
						<c:param name="importantNo" value="${important.importantNo }"></c:param>
						<c:param name="projectNo" value="${projectNo }"></c:param>
					</c:url>
					<td><a href="${iDetail }">${important.importantTitle }</a></td>
					<td>${important.importantDate }</td>
					<td>${important.importantCount }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		<div>
		
		</div>
		</div>
</body>
</html>
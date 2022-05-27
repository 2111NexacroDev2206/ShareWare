<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 리스트</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/notice/noticeList-style.css">
</head>
<body>
<jsp:include page="../notice/noticeMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="h-title">자료실 목록</h2>
			<button id="writeBtnDiv" onclick="location.href='/fileBoard/WriteView.sw'">작성</button>
		<br><br>
		<table class="type01">
		<thead>
			<tr>
				<th colspan="2" class="th-3">&nbsp;&nbsp;&nbsp;제 목</th>
				<th class="th-2">작성자</th>
				<th class="th-2">작성일</th>
				<th class="th-1">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="num" value="${totalCount - ((currentPage-1) * 10) }"/>
				<c:forEach items="${fList }" var="fileBoard">
						<tr>
							<td id="no">${num} </td>
								<c:url var="fDetail" value="/fileBoard/detail.sw">
									<c:param name="fileBoardNo" value="${fileBoard.fileBoardNo }"></c:param>
								</c:url>
							<td class="td-title"><a href ="${fDetail}">${fileBoard.fileBoardTitle }</a></td>
							<td>${fileBoard.member.memberName }</td>
							<td>${fileBoard.fileBoardDate }</td>
							<td>${fileBoard.fileBoardView }</td>
						</tr>
						<c:set var="num" value="${num-1 }"></c:set>
				</c:forEach>
		</tbody>
		</table>
		<div class="paging">
			<jsp:include page="fileBoardPagin.jsp"></jsp:include>
		</div>
		</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 목록</title>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h1>일일 업무목록</h1>
			<a href="/report/dailyWriteView.sw">+일지작성</a>
		<table align="center" width="" border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dList }" var="daily" varStatus="status"> 
				<tr>
					<td>${fn:length(dList ) - status.count + 1}</td>
					<c:url var="drDetail" value="/report/dailyDetail.sw">
						<c:param name="drNo" value="${daily.drNo }"></c:param>
					</c:url>			
					<td><a href="${drDetail}">${daily.drTitle }</a></td>
					<td>${daily.drDate }</td>
					<td>${daily.drWriter }</td>	
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
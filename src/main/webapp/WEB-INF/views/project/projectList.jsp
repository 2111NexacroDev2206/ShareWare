<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 목록페이지</title>
</head>
<body>
<jsp:include page="projectMenu.jsp"></jsp:include>
		<div class="s-container">
		<div>
			<h2>나의 프로젝트</h2>
		</div>
			<table align="center" border="1">
				<thead>
				 	<tr>
				 		<th>번호</th>
				 		<th>프로젝트명</th>
				 		<th>담당자</th>
				 		<th>시작일</th>
				 		<th>상태</th>
				 	</tr>
				 </thead>
				 <tbody>
				 <c:forEach items="${pList }" var="project" varStatus="status">
				 	<tr>
				 		<td>${fn:length(pList ) - status.count + 1}</td>
				 		<c:url var="pDetail" value="/project/main.sw">
				 			<c:param name="projectNo" value="${project.projectNo }"></c:param>
				 		</c:url>
				 		<td><a href="${pDetail}">${project.projectTitle}</a></td>
				 		<td>${loginUser.memberName }</td>
				 		<td>${project.pStartDate}</td>
				 		<td>
							<c:if test="${project.pStatus eq 'Y' }">
				 				진행중
				 			</c:if>
				 			<c:if test="${project.pStatus eq 'N' }">
				 				종료
				 			</c:if>
				 		</td>
				 	</tr>
				 </c:forEach>
				 </tbody>
			</table>
	</div>
</body>
</html>
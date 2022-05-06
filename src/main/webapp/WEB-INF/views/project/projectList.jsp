<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				 		<th>기간</th>
				 		<th>상태</th>
				 	</tr>
				 </thead>
				 <tbody>
				 <jsp:useBean id="now" class="java.util.Date" />
				 <fmt:formatDate value="${now}" pattern="yyyyMMdd" var="nowDate" /> 
				 <c:forEach items="${pList }" var="project" varStatus="status">
					
				 	<tr>
				 		<td>${fn:length(pList ) - status.count + 1}</td>
				 		<c:url var="pDetail" value="/project/main.sw">
				 			<c:param name="projectNo" value="${project.projectNo }"></c:param>
				 		</c:url>
				 		<td><a href="${pDetail}">${project.projectTitle}</a></td>
				 		<td>${project.projectMade }</td>
				 		<td>${project.pStartDate} ~ ${project.pEndDate}</td>
				 		<td>
							<c:if test="${project.pEndDate >= nowDate  }">
				 				<input type="hidden" value="Y" name="pStatus">진행중
				 			</c:if>
				 			<c:if test="${project.pEndDate < nowDate  }">
							 	<input type="hidden" value="N" name="pStatus" >종료
							</c:if>
				 		</td>
				 	</tr>
				 </c:forEach>
				 </tbody>
			</table>
	</div>
</body>
</html>
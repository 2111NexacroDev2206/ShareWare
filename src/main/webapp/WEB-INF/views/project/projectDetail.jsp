<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 정보 상세</title>
<link href="/resources/css/project/project.css" rel="stylesheet">
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/projectRegister.sw" method="post">
		<div>
		<br>
			<div>
				<span id="title">프로젝트 정보</span>
			</div>
			<br>
			<div>
				<table class="project-tbl">
					<tr>
						<td>프로젝트 명</td>
						<td>${project.projectTitle }</td>
					</tr>
					<tr>
						<td>진행기간</td>
						<td>${project.pStartDate } ~ ${project.pEndDate }</td>
					</tr>
					<tr>
						<td>프로젝트 관리자</td>
						<td>${project.projectMadeName }</td>
					</tr>
					<tr>
						<td>프로젝트 참여자</td>
						<td>
						 <c:forEach items="${pList }" var="participant">
							${participant.division } ${participant.memberName } ${participant.rank } <br>
						 </c:forEach>
						</td>
					</tr>
					<tr>
						<td>프로젝트 내용</td>
						<td>${project.projectContent }</td>
					</tr>
					<tr>
						<td colspan="2">
								<c:if test="${loginUser.memberNum eq project.projectMade}">
									<input type="button" id="btn" onclick="location.href='/project/projectModifyView.sw?projectNo=${project.projectNo }'" value="수정">
								</c:if>
									<input type="button" id="btn" onclick="location.href='/project/main.sw?projectNo=${project.projectNo }'" value="목록">
						</td>
					</tr>
				</table>
			</div>
		</div>
		</form>
	</div>
	<jsp:include page="projectModal.jsp"></jsp:include> <!-- 참여자 선택 모달 -->
</body>
</html>
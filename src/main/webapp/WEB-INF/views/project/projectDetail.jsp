<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 정보 상세</title>
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/projectRegister.sw" method="post">
		<div>
			<div>
				<h2>프로젝트 정보</h2>
			</div>
			<div>
				<table border="1">
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
						<td>${project.projectMade }</td>
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
						<td colspan="2" align="left">
								<input type="button" onclick="location.href='/project/projectModifyView.sw?projectNo=${project.projectNo }'" value="수정">
								<input type="button" onclick="location.href='/project/main.sw?projectNo=${project.projectNo }'" value="취소">
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
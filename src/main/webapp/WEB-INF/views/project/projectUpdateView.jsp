<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 수정 페이지</title>
<link href="/resources/css/project/project.css" rel="stylesheet">
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/projectUpdate.sw" method="post">
			<br>
			<div>
				<span id="title">프로젝트 정보 수정</span>
			</div>
			<br>
			<div>
				<table class="project-tbl-update">
					<tr>
						<td>프로젝트 명</td>
						<td><input type="text" id="name" name="projectTitle" value="${project.projectTitle }"></td>
					</tr>
					<tr>
						<td>진행기간</td>
						<td><input type="date" id="date" name="pStartDate" value="${project.pStartDate }"> ~ <input type="date" id="date" name="pEndDate" value="${project.pEndDate }"> </td>
					</tr>
					<tr>
						<td>프로젝트 관리자</td>
						<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="projectMade" readonly></td>
					</tr>
					<tr>
						<td>프로젝트 참여자 <button id="par-btn" type="button" onclick="participant();"><i class="fa-solid fa-user-plus fa-lg"></i></button></td>
						<td>
							<div id="par-list" style="overflow-x:hidden;overflow-y:scroll;">
							<c:forEach items="${pList }" var="participant">
								 &nbsp;&nbsp;${participant.division } ${participant.memberName } ${participant.rank } <br>
						 	</c:forEach>
							</div>
						</td>
						<input type="hidden" id="num-par" name="memNum" readonly>
						<input type="hidden" value="${project.projectNo }" name="projectNo" readonly>
					</tr>
					<tr>
						<td>프로젝트 내용</td>
						<td><textarea id="project-content" name="projectContent" value="${project.projectContent }"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="btn" type="submit" value="저 장">
							<input id="btn" type="button" onclick="delPop();" value="삭 제">
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="projectModal.jsp"></jsp:include> <!-- 참여자 선택 모달 -->
</body>
<script>
function delPop(){
	var truefalse = confirm("삭제하시겠습니까?");
	if(truefalse) {
	location.href='/project/projectDelete.sw?projectNo=${project.projectNo}';
	}
}</script>
</html>
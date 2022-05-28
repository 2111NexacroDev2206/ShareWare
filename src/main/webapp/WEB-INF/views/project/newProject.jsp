<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 생성 페이지</title>
<link href="/resources/css/project/project.css" rel="stylesheet">
</head>
<body>
<jsp:include page="projectMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/projectRegister.sw" method="post">
		<div>
			<div>
				<span id="title">새 프로젝트 생성</span>
			</div>
			<div>
				<table class="project-tbl-update">
					<tr>
						<td>프로젝트 명</td>
						<td><input type="text" id="name" name="projectTitle" placeholder="내용을 입력해주세요"></td>
					</tr>
					<tr>
						<td>진행기간</td>
						<td><input type="date" id="date" name="pStartDate"> ~ <input type="date" id="date" name="pEndDate"> </td>
					</tr>
					<tr>
						<td>프로젝트 관리자</td>
						<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="projectMade" readonly></td>
					</tr>
					<tr>
						<td>프로젝트 참여자 <button id="par-btn" type="button" onclick="participant();"><i class="fa-solid fa-user-plus fa-lg"></i></button></td>
						<td>
							<div id="par-list" style="overflow-x:hidden;overflow-y:scroll;">
							</div>
						</td>
						<input type="hidden" id="num-par" name="memNum" readonly>
					</tr>
					<tr>
						<td>프로젝트 내용</td>
						<td><textarea id="project-content" name="projectContent" placeholder="내용을 입력해주세요"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input id="btn" type="submit" value="등 록">
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
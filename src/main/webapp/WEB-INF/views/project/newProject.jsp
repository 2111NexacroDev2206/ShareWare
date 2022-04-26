<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 생성 페이지</title>
</head>
<body>
<jsp:include page="projectMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/projectRegister.sw" method="post">
		<div>
			<div>
				<h2>새 프로젝트 생성</h2>
			</div>
			<div>
				<table>
					<tr>
						<td>프로젝트 명</td>
						<td><input type="text" name="projectTitle"></td>
					</tr>
					<tr>
						<td>진행기간</td>
						<td><input type="date" name="pStartDate"> ~ <input type="date" name="pEndDate"> </td>
					</tr>
					<tr>
						<td>프로젝트 관리자</td>
						<td><input type="text" value="${loginUser.memberName }" name="projectMade" readonly></td>
					</tr>
					<tr>
						<td>프로젝트 참여자</td>
						<td>
							<button type="button" onclick="participant();"> + </button>
							<p id="par-list">
						</td>
						<input type="hidden" id="num-par" name="memNum" readonly>
					</tr>
					<tr>
						<td>프로젝트 내용</td>
						<td><textarea name="projectContent"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="등 록">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 수정 페이지</title>
</head>
<body>
<jsp:include page="projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/projectUpdate.sw" method="post">
		<div>
			<div>
				<h2>프로젝트 정보 수정</h2>
			</div>
			<div>
				<table>
					<tr>
						<td>프로젝트 명</td>
						<td><input type="text" name="projectTitle" value="${project.projectTitle }"></td>
					</tr>
					<tr>
						<td>진행기간</td>
						<td><input type="date" name="pStartDate" value="${project.pStartDate }"> ~ <input type="date" name="pEndDate" value="${project.pEndDate }"> </td>
					</tr>
					<tr>
						<td>프로젝트 관리자</td>
						<td>${loginUser.memberName }<input type="hidden" value="${loginUser.memberNum }" name="projectMade" readonly></td>
					</tr>
					<tr>
						<td>프로젝트 참여자</td>
						<td>
							<button type="button" onclick="participant();"> + </button>
							<p id="par-list">
							<c:forEach items="${pList }" var="participant">
								${participant.division } ${participant.memberName } ${participant.rank } <br>
						 	</c:forEach>
						</td>
						<input type="hidden" id="num-par" name="memNum" readonly>
						<input type="hidden" value="${project.projectNo }" name="projectNo" readonly>
					</tr>
					<tr>
						<td>프로젝트 내용</td>
						<td><textarea name="projectContent" value="${project.projectContent }"></textarea></td>
					</tr>
					<tr>
						<input type="submit" value="저 장">
						<input type="button" onclick="delPop();" value="삭제">
					</tr>
				</table>
			</div>
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
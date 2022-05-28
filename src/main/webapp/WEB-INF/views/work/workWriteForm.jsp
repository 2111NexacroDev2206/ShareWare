<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업무현황 작성페이지</title>
<link href="/resources/css/work/work-form.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<h2 id="w-title">업무진행현황</h2>
		<form action="/project/workRegister.sw" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${projectNo }" name="projectNo">
			<input type="hidden" value="${nowTime }" name="workDate">
			<table class="work-tbl">
				<tr>
					<td id="tit">제목</td>
					<td><input type="text" name="workTitle" style="height:30px;width:500px;font-size:large;"></td>
				</tr>
				<tr>
					<td id="tit">작성자</td>
					<td id="writer"><input type="hidden" value="${loginUser.memberName}" name="workWriter">${loginUser.memberName}</td>
					<input type="hidden" value="${loginUser.memberNum}" name="memNum">
				</tr>
				<tr>
					<td id="tit">파일첨부</td>
					<td><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="workContent"></textarea></td>
				</tr>
			</table>
				<input id="btn" type="button" onclick="location.href='/project/workList.sw?projectNo=${projectNo}'" value="취소">
				<input id="btn" type="submit" value="등록">
		</form>
	</div>
</body>
</html>
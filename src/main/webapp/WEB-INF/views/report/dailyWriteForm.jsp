<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 작성 </title>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 일 일 업 무 일 지</h3>
		<form action="/report/dailyRegister.sw" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr> 
				<td>제목</td>
				<td><input type="text" name="drTitle" ></td>
				<td>부서명</td>
				<td><input type="text" >${login.divName }</td>
			</tr>
			<tr> 
				<td>작성일</td>
				<td><input value="${nowTime }" name="drDate"></td>
				<td>작성자</td>
				<td><input type="text" name="drWriter"></td>
			</tr>
			<tr> 
				<td colspan="3">업무내용</td>
				<td colspan="1">처리내용</td>
			</tr>
			<tr>
				<td colspan="3"><textarea name="drContent"></textarea></td>
				<td colspan="1"><textarea name="drCompletion"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" >비 고</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="drNote"></textarea></td>
			</tr>
		</table>
		<p>파일첨부 <input type="file" name="uploadFile"> 
		<input type="reset" value="취소">
		<input type="submit" value="등록">
	</form>
	</div>
</body>
</html>
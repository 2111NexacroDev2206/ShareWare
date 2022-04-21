<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 상세 </title>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 일 일 업 무 일 지</h3>
		<table border="1">
			<tr> 
				<td>제목</td>
				<td>${daily.drNo }</td>
				<td>부서명</td>
				<td>${loginUser.divName }</td>
			</tr>
				<tr> 
				<td>작성일</td>
				<td>${daily.drDate }</td>
				<td>작성자</td>
				<td>${daily.drWriter }</td>
			</tr>
			<tr> 
				<td colspan="3">업무내용</td>
				<td colspan="1">처리내용</td>
			</tr>
			<tr>
				<td colspan="3"><textarea name="drContent">${daily.drContent }</textarea></td>
				<td colspan="1"><textarea name="drCompletion">${daily.drCompletion }</textarea></td>
			</tr>
			<tr>
				<td colspan="4" >비 고</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="drNote">${daily.drNote }</textarea></td>
			</tr>
		</table>
		<p>파일첨부 <input type="file" name="uploadFile"> 
		<input type="button" onclick="location.href='/report/dailyModifyView.sw?drNo=${daily.drNo}'" value="수정">
		<input type="button" onclick="location.href='/report/dailyDelete.sw?drNo=${daily.drNo}'" value="삭제">
		<input type="button" onclick="location.href='/report/dailyList.sw'" value="목록">
	</div>
</body>
</html>
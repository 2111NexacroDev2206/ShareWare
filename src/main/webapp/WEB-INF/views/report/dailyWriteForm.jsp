<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 업무 작성 </title>
</head>
<body>
	<form action="/report/dailyRegister.sw" method="post" enctype="multipart/form-data">
	<div>
		<h3> 일 일 업 무 일 지</h3>
	</div>
	<div>
		<table>
			<tr> 
				<td>제목</td>
				<td><input type="text" name="drTitle" ></td>
				<td>부서명</td>
				<td><input type="hidden"></td>
			</tr>
				<tr> 
				<td>작성일</td>
				<td><input type="text" value="${nowTime }" name="drDate"></td>
				<td>작성자</td>
				<td><input type="text" name="drWriter"></td>
			</tr>
			<tr></tr>
		</table>
		</div>
		
		<div>
		<table border="1">
			<tr> 
				<td>업무내용</td>
				<td>처리내용</td>
			</tr>
			<tr>
				<td><textarea name="drContent"></textarea></td>
				<td><textarea name="drCompletion"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" >비 고</td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="drNote"></textarea></td>
			</tr>
		</table>
	</div>
	<div>
		파일첨부 <input type="file"> 
		<input type="reset" value="취소">
		<input type="submit" value="등록">
	</div>
	</form>
</body>
</html>
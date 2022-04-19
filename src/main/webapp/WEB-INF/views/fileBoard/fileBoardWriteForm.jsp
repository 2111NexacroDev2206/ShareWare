<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료게시판 글쓰기</title>
</head>
<body>
	<h1>자료 등록 페이지(임시)</h1>
	<form action="/community/register.sw" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>제목</td>
			<td></td>
		</tr>
		<tr>
			<td>본문</td>
			<td></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
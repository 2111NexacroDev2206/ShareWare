<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 작성</title>
</head>
<body>
	<div>
		<h3> 주 간 업 무 일 지</h3>
	</div>
	<div>
		<table>
		<tr> 
			<td>제목</td>
			<td><input type="text"></td>
			<td>부서명</td>
			<td><input type="text"></td>
		</tr>
			<tr> 
			<td>작성일자</td>
			<td><input type="text"></td>
			<td>작성자</td>
			<td><input type="hidden"></td>
		</tr>
		</table>
	</div>
	<div>
		<table>
			<tr> 
				<td>일자</td>
				<td>업무 제목</td>
				<td>업무 내용</td>
			</tr>
			<tr>
				<td><input type="text"></td>
				<td><textarea></textarea></td>
				<td><textarea></textarea></td>
			</tr>
			<tr>
				<td colspan="3">중 요 사 항</td>
			</tr>
			<tr>
				<td colspan="3"><textarea></textarea></td>
			</tr>
		</table>
	</div>
	<div>
		파일첨부 <input type="file"> 
		<input type="button" class="" value="취소">
		<input type="submit" class="" value="등록">
	</div>
</body>
</html>
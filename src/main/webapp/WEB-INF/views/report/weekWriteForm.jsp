<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 작성</title>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 주 간 업 무 일 지</h3>
		<form action="/report/weekRegister.sw" method="post" enctype="multipart/form-data">
		<table border="1">
		<tr> 
			<td rowspan="2">제목</td>
			<td rowspan="2"><input type="text" name="wrTitle" ></td>
			<td>부서명</td>
			<td><input type="text" >${login.divName }</td>
		</tr>
		<tr> 
			<td>작성자</td>
			<td><input type="text" name="wrWriter"></td>
		</tr>
			<tr> 
				<td>일자</td>
				<td colspan="2">업무 제목</td>
				<td>업무 내용</td><input type="hidden" input value="${nowTime }" name="wrDate">
			</tr>
			<tr>
				<td><input type="text" name=""></td>
				<td colspan="2"><textarea name="wrTle"></textarea></td>
				<td><textarea name="wrContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="text" name=""></td>
				<td colspan="2"><textarea name="wrTle"></textarea></td>
				<td><textarea name="wrContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="text" name=""></td>
				<td colspan="2"><textarea name="wrTle"></textarea></td>
				<td><textarea name="wrContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="text" name=""></td>
				<td colspan="2"><textarea name="wrTle"></textarea></td>
				<td><textarea name="wrContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="text" name=""></td>
				<td colspan="2"><textarea name="wrTle"></textarea></td>
				<td><textarea name="wrContent"></textarea></td>
			</tr>
			<tr>
				<td><input type="text" name=""></td>
				<td colspan="2"><textarea name="wrTle"></textarea></td>
				<td><textarea name="wrContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">중 요 사 항</td>
			</tr>
			<tr>
				<td colspan="4" name=""><textarea></textarea></td>
			</tr>
		</table>
		파일첨부 <input type="file"> 
		<input type="button" class="" value="취소">
		<input type="submit" class="" value="등록">
	</form>
	</div>
	<script>
	var date1 = new Date();
	console.log(date1);
	console.log(date1.getFullYear());
	$("#fullYear").val(date1.getFullYear());
	var date2 = new Date();
	console.log(date2);
	console.log(date2.getMonth()+1);
	$("#month").val(date2.getMonth()+1);
	</script>
</body>
</html>
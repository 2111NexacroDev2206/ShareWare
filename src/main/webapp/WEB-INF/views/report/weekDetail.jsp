<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 상세</title>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 주 간 업 무 일 지</h3>
		<table border="1">
		<tr> 
			<td rowspan="2">제목</td>
			<td rowspan="2">${week.wrNo }</td>
			<td>부서명</td>
			<td>${login.divName }</td>
		</tr>
		<tr> 
			<td>작성자</td>
			<td>${week.wrWriter }</td>
		</tr>
			<tr> 
				<td>일자</td>
				<td colspan="2">업무 제목</td>
				<td>업무 내용</td>
			</tr>
			<tr>
				<td>${week.wrDate} </td>
				<td colspan="2">${week.wrTle }</td>
				<td>${week.wrContent }</td>
			</tr>
			<tr>
				<td>${week.wrDate} </td>
				<td colspan="2">${week.wrTle }</td>
				<td>${week.wrContent }</td>
			</tr>
			<tr>
				<td>${week.wrDate} </td>
				<td colspan="2">${week.wrTle }</td>
				<td>${week.wrContent }</td>
			</tr>
			<tr>
				<td>${week.wrDate} </td>
				<td colspan="2">${week.wrTle }</td>
				<td>${week.wrContent }</td>
			</tr>
			<tr>
				<td>${week.wrDate} </td>
				<td colspan="2">${week.wrTle }</td>
				<td>${week.wrContent }</td>
			</tr>
			<tr>
				<td>${week.wrDate} </td>
				<td colspan="2">${week.wrTle }</td>
				<td>${week.wrContent }</td>
			</tr>
			<tr>
				<td colspan="4">중 요 사 항</td>
			</tr>
			<tr>
				<td colspan="4" name="wrNote"><textarea>${week.wrNote }</textarea></td>
			</tr>
		</table>
		<p>파일첨부 <input type="file" name="uploadFile"> 
		<input type="button" onclick="location.href='/report/weekModifyView.sw?wrNo=${week.wrNo}'" value="수정">
		<input type="button" onclick="location.href='/report/weekDelete.sw?wrNo=${week.wrNo}'" value="삭제">
		<input type="button" onclick="location.href='/report/weekList.sw'" value="목록">
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
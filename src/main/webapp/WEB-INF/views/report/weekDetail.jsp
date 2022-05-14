<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주간 업무 상세</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<jsp:include page="reportMenu.jsp"></jsp:include>
	<div class="s-container">
		<h3 align="center"> 주 간 업 무 일 지</h3>
		<table border="1" id="h-table">
		<tr> 
			<td rowspan="2">제목</td>
			<td rowspan="2">${week.wrTitle }</td>
			<td>부서명</td>
			<td>${loginUser.division }</td>
		</tr>
		<tr> 
			<td>작성자</td>
			<td>${week.wrWriter }
			<input type="hidden" value="${nowTime }"></td>
		</tr>
			<tr> 
				<td>일자</td>
				<td colspan="2">업무 제목</td>
				<td>업무 내용</td>
			</tr>
			<tr>
                  <td colspan="4">
                 		${week.wrContent }
				</td>
			</tr>
		</table>
		<p>첨부파일 </p>
		<a href="../../../resources/wuploadFiles/${week.fileReName }" download>
		 		${week.fileName }
				</a>
		<input type="button" onclick="location.href='/report/weekModifyView.sw?wrNo=${week.wrNo}'" value="수정">
		<input type="button" onclick="delPop();" value="삭제">
		<input type="button" onclick="location.href='/report/weekList.sw'" value="목록">
	</div>
	<script>
		function delPop(){
			var truefalse = confirm("삭제하시겠습니까?");
			if(truefalse) {
			location.href='/report/weekDelete.sw?wrNo=${week.wrNo}';
			}
		}
	</script>
</body>
</html>